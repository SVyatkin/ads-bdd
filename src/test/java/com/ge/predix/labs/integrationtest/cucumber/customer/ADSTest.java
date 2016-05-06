package com.ge.predix.labs.integrationtest.cucumber.customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.util.Assert;

import com.ge.ams.dto.City;
import com.ge.ams.dto.Country;
import com.ge.ams.dto.State;
import com.ge.predix.labs.common.JsonMapper;
import com.ge.predix.labs.integrationtest.RestTestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ADSTest extends RestTestBase {
	List<Country> countries;
	List<City> cities;
	List<State> states;
	
	@Given("^the countries table _ADS_$")
	public void the_countries_table__ADS_(List<WCountry> countries) throws Throwable {
		rest.post(config.paths.prefix + "/countries", JsonMapper.toJson(countries));
	}

	@Given("^the states table _ADS_$")
	public void the_states_table__ADS_(List<WState> states) throws Throwable {
		rest.post(config.paths.prefix + "/states", JsonMapper.toJson(states));
	}

	@Given("^the cities table _ADS_$")
	public void the_cities_table__ADS_(List<WCity> cities) throws Throwable {
		rest.post(config.paths.prefix + "/cities", JsonMapper.toJson(cities));
	}

	@When("^a user queries a list of countries by city name \"([^\"]*)\" _ADS_$")
	public void a_user_queries_a_list_of_countries_by_city_name__ADS_(String city) throws Throwable {
		countries = retrieveAll(Country.class, "name=" +city+ ">parent[t3]");
	}

	@Then("^a list of countries should be returned _ADS_$")
	public void a_list_of_counries_should_be_returned__ADS_(List<String> countries) throws Throwable {
		Set<String> set = new HashSet<String>();
		Set<String> set1 = new HashSet<String>(countries);
		for (Country c : this.countries) set.add(c.getName());
		Assert.isTrue(set.containsAll(set1));
	}
	
	@When("^a user queries a list of countries _ADS_$")
	public void a_user_queries_a_list_of_countries__ADS_() throws Throwable {
		countries = retrieveAll(Country.class, null);
	}

	@When("^a user queries a list of states _ADS_$")
	public void a_user_queries_a_list_of_states__ADS_() throws Throwable {
		states = retrieveAll(State.class, null);
	}

	@Then("^a list of states should be returned _ADS_$")
	public void a_list_of_states_should_be_returned__ADS_(List<String> states) throws Throwable {
		Set<String> set = new HashSet<String>();
		Set<String> set1 = new HashSet<String>(states);
		for (State c : this.states) set.add(c.getName());
		Assert.isTrue(set.containsAll(set1));
	}
	
	@When("^a user queries a list of cities _ADS_$")
	public void a_user_queries_a_list_of_cities__ADS_() throws Throwable {
		cities = retrieveAll(City.class, null);
	}

	@Then("^a list of cities should be returned _ADS_$")
	public void a_list_of_cities_should_be_returned__ADS_(List<String> cities) throws Throwable {
		Set<String> set = new HashSet<String>();
		Set<String> set1 = new HashSet<String>(cities);
		for (City c : this.cities) set.add(c.getName());
		Assert.isTrue(set.containsAll(set1));
	}
	
}

class WCountry extends Country {

	public WCountry(String uri, String name) {
		setUri(uri);
		setName(name);

	}
}

class WState extends State {

	public WState(String uri, String name, String parent) {
		setUri(uri);
		setName(name);
		setParent(parent);
	}

}

class WCity extends City {

	public WCity(String uri, String name, String parent) {
		setUri(uri);
		setName(name);
		setParent(parent);
	}

}
