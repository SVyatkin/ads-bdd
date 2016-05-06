package com.ge.predix.labs.integrationtest.cucumber.customer;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.lang.JoseException;
import org.springframework.util.Assert;

import com.ge.ams.dto.Manufacture;
import com.ge.ams.dto.Windfarm;
import com.ge.ams.dto.Windturbine;
import com.ge.predix.labs.common.JsonMapper;
import com.ge.predix.labs.integrationtest.RestTestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WTTest extends RestTestBase {
	List<Windturbine> wt = new ArrayList<Windturbine>();
	Map<String, Windturbine> mapWTOriginal = new HashMap<String, Windturbine>();
	Map<String, Windturbine> mapWTProcessed = new HashMap<String, Windturbine>();
	
    static KeyPair keyPair; 
    
	public static void initKey() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		keyPair = keyPairGenerator.genKeyPair();
	}
	
	@Given("^the wind farms table _WT_$")
	public void the_wind_farms_table__WT_(List<WWindfarm> windFarms) throws Throwable {
		List<Windfarm> wt = new ArrayList<Windfarm>();
		for(WWindfarm w:windFarms){
			wt.add(w.getWindfarm());
		}
		rest.post(config.paths.prefix + "/windfarm", JsonMapper.toJson(wt));
	}

	@Given("^the manufacture table _WT_$")
	public void the_manufacture_table__WT_(List<Manufacture> manufactures) throws Throwable {
		rest.post(config.paths.prefix + "/manufacture", JsonMapper.toJson(manufactures));
	}
	
	@Given("^the wind turbines table _WT_$")
	public void the_wind_turbines_table__WT_(List<WWindturbine> wwt) throws Throwable {
		List<Windturbine> wt = new ArrayList<Windturbine>();
		for(WWindturbine w:wwt){
			wt.add(w.getWindturbine());
		}
		rest.post(config.paths.prefix + "/windturbine", JsonMapper.toJson(wt));
	}
	
	@When("^a user queries a list of wind turbines _WT_$")
	public void a_user_queries_a_list_of_wind_turbines__WT_() throws Throwable {
		wt = retrieveAll(Windturbine.class, null);
	}

	@Then("^a list of wind turbines should be returned _WT_$")
	public void a_list_of_wind_turbines_should_be_returned__WT_(List<String> wtUris) throws Throwable {
		Set<String> set = new HashSet<String>();
		Set<String> set1 = new HashSet<String>(wtUris);
		for (Windturbine w : this.wt) set.add(w.getUri());
		Assert.isTrue(set.containsAll(set1));
	}
	
/**
 *   Digital Signature
 */
	
	@Given("^the wind turbine \"([^\"]*)\" with digital signature _WT_$")
	public void the_wind_turbine_with_digital_signature__WT_(String wtName, List<WWindturbine> wwt) throws Throwable {
		initKey();
		
		List<Windturbine> wt = new ArrayList<Windturbine>();
		Windturbine wTemp = wwt.get(0).getWindturbine(); 
	    String jwsSignature = getSignature(wTemp);

	    wTemp.setSignature(jwsSignature);
	    wt.add(wTemp);
	    
       // Post payload with signature 
		rest.post(config.paths.prefix + "/windturbine", JsonMapper.toJson(wt));
		mapWTOriginal.put(wtName,wTemp);
	}

private String getSignature(Windturbine wTemp) throws JoseException {
	// Create a new JsonWebSignature
	JsonWebSignature jws = new JsonWebSignature();

	// Set the payload
	jws.setPayload(JsonMapper.toJson(wTemp));

	// Set the signature algorithm on the JWS that will integrity protect the payload
	jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

	
	// Set the signing key on the JWS
	// Note that your application will need to determine where/how to get the key
	jws.setKey(keyPair.getPrivate());

	// Sign the JWS and produce the compact serialization or complete JWS representation, which
	String jwsCompactSerialization = jws.getCompactSerialization();
	return jwsCompactSerialization;
}
	
/**
 *  Update with Signature
 */

	@Given("^the wind turbine \"([^\"]*)\" updated with new signature _WT_$")
	public void the_wind_turbine_updated_with_new_signature__WT_(String wtName, List<WWindturbine> wwt) throws Throwable {
		Windturbine wtProcessed = mapWTProcessed.get(wtName);
		Windturbine wtUpdate = wwt.get(0).getWindturbine();
		wtUpdate.setUri(wtProcessed.getUri());
		wtUpdate.setSignature(getSignature(wtUpdate));
		List<Windturbine> wt = new ArrayList<Windturbine>();
		wt.add(wtUpdate);
	    // Put payload with signature 
	    rest.post(config.paths.prefix + "/windturbine", JsonMapper.toJson(wt));
	    mapWTOriginal.put(wtName, wtUpdate);
	}

/**
 * 	Updated with fake Signature
 */
	
	@Given("^the wind turbine \"([^\"]*)\" updated _WT_$")
	public void the_wind_turbine_updated__WT_(String wtName, List<WWindturbine> wwt) throws Throwable {
		
		Windturbine wtProcessed = mapWTProcessed.get(wtName);
		Windturbine wtUpdate = wwt.get(0).getWindturbine();
		wtUpdate.setUri(wtProcessed.getUri());
		wtUpdate.setSignature(wtProcessed.getSignature());
		List<Windturbine> wt = new ArrayList<Windturbine>();
		wt.add(wtUpdate);
	    // Put payload with signature 
	    rest.post(config.paths.prefix + "/windturbine", JsonMapper.toJson(wt));
	    mapWTOriginal.put(wtName, wtUpdate);
	}

	
	@When("^a user queries \"([^\"]*)\" wind turbine _WT_$")
	public void a_user_queries_wind_turbine__WT_(String wtName) throws Throwable {
		Windturbine wtt = retrieveOne(Windturbine.class, mapWTOriginal.get(wtName).getUri());
		mapWTProcessed.put(wtName, wtt);
		
	}

	@Then("^wind turbine \"([^\"]*)\" signature is \"([^\"]*)\" _WT_$")
	public void wind_turbine_signature_is__WT_(String wtName, Boolean signatureStatus) throws Throwable {
		// Create a new JsonWebSignature
		JsonWebSignature jws = new JsonWebSignature();
		
		// Set the compact serialization on the JWS
		jws.setCompactSerialization(mapWTProcessed.get(wtName).getSignature());
		
		// Set the public key
		// Note that your application will need to determine where/how to get the key
		jws.setKey(keyPair.getPublic());
		
		// Check the signature exist
		Assert.isTrue(jws.verifySignature());
		String payload = jws.getPayload();
		Assert.isTrue(payload.equals(JsonMapper.toJson(getWithoutSignature(mapWTProcessed.get(wtName)))) == signatureStatus);
	}

	private Windturbine  getWithoutSignature(Windturbine windturbine) {
		Windturbine wT = new Windturbine();
		wT.setLocation(windturbine.getLocation());
		wT.setUri(windturbine.getUri());
		wT.setModel(windturbine.getModel());
		wT.setFrequency(windturbine.getFrequency());
		wT.setPower(windturbine.getPower());
		wT.setTowerType(windturbine.getTowerType());
		wT.setHubHeight(windturbine.getHubHeight());
		wT.setRotorDiameter(windturbine.getRotorDiameter());
		wT.setBladeType(windturbine.getBladeType());
		wT.setRatedWindSpeed(windturbine.getRatedWindSpeed());
		wT.setCertification(windturbine.getCertification());
		return wT;
	}


}

class WWindfarm extends Windfarm {
	Double lat;
	Double lng;

	public WWindfarm(String uri, String name, String owner, Double lat,
			Double lng) {
		setUri(uri);
		setName(name);
		setOwner(owner);
		this.lat = lat;
		this.lng = lng;
	}

	Windfarm getWindfarm() {
		LinkedHashMap<String, Double> location = new LinkedHashMap<String, Double>();
		location.put("lat", this.lat);
		location.put("long", this.lng);
		Windfarm windFarm = new Windfarm();
		windFarm.setLocation(location);
		windFarm.setUri(getUri());
		windFarm.setName(getName());
		windFarm.setOwner(getOwner());
		return windFarm;
	}
}

class WWindturbine extends Windturbine {

    public WWindturbine(String uri, 
    		String name, 
    		String model, 
    		String parent,
			Boolean obsolete, String frequency, String power, String towerType,
			Double rotorDiameter, Double hubHeight, String nacelle,
			String bladeType, String ratedWindSpeed, String certification,
			Double lat, Double lng) {
    	
		setUri(uri);
		setName(name);
		setModel(model);
		setParent(parent);
		setFrequency(frequency);
		setPower(power);
		setTowerType(towerType);
		setHubHeight(hubHeight);
		setRotorDiameter(rotorDiameter);
		setBladeType(bladeType);
		setRatedWindSpeed(ratedWindSpeed);
		setCertification(certification);
		this.lat = lat;
		this.lng =lng;
	}
    
    Double lat;
    Double lng;
    Windturbine getWindturbine(){
		LinkedHashMap<String,  Double> location = new LinkedHashMap<String,  Double>();
		location.put("lat", this.lat);
		location.put("long", this.lng);
		Windturbine windTurbine = new Windturbine();
		windTurbine.setLocation(location);
		windTurbine.setUri(getUri());
		windTurbine.setModel(getModel());
		windTurbine.setFrequency(getFrequency());
		windTurbine.setPower(getPower());
		windTurbine.setTowerType(getTowerType());
		windTurbine.setHubHeight(getHubHeight());
		windTurbine.setRotorDiameter(getRotorDiameter());
		windTurbine.setBladeType(getBladeType());
		windTurbine.setRatedWindSpeed(getRatedWindSpeed());
		windTurbine.setCertification(getCertification());
		return windTurbine;
    	
    }
}
