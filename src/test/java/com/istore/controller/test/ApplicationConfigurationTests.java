/*
 * Copyright 2012-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.istore.controller.test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.istore.ApplicationConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic integration tests for Restful demo application.
 *
 * @author Indrajeet Harale
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationConfiguration.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public class ApplicationConfigurationTests {

	@Value("${local.server.port}")
	private int port;

	/**
	 * Test creation of shops API	
	 * @throws Exception
	 */
	@Test
	public void testCreateShop() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		 HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		 Map<String, Object> apiResponse =
				  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=apple store&shopAddress=7021 S Memorial Dr, Tulsa, OK 74133, United States&shopNumber=1&shopPostalCode=74133", httpEntity, Map.class, Collections.EMPTY_MAP);
		  String shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		  apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=1901 NW Expressway Street, Oklahoma City, OK 73118, United States&shopNumber=2&shopPostalCode=73118", httpEntity, Map.class, Collections.EMPTY_MAP);
		  shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
			  apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=4529 W 119th St, Leawood, KS 66209, United States&shopNumber=3&shopPostalCode=66209", httpEntity, Map.class, Collections.EMPTY_MAP);
		  shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		  
	}


	/**
	 * Test get details  of shops API	
	 * @throws Exception
	 */
	@Test
	public void testGetShop() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		  HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		//Invoking the API
		 @SuppressWarnings("unchecked")
		 Map<String, Object> apiResponse =
				  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=7021 S Memorial Dr, Tulsa, OK 74133, United States&shopNumber=1&shopPostalCode=74133", httpEntity, Map.class, Collections.EMPTY_MAP);
		  String shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		  apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=132 South Avenue, Bloomington, MN 55425, United States&shopNumber=2&shopPostalCode=55425", httpEntity, Map.class, Collections.EMPTY_MAP);
		  shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
			  apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress= 1901 NW Expressway Street, Oklahoma City, OK 73118, United States&shopNumber=3&shopPostalCode=73118", httpEntity, Map.class, Collections.EMPTY_MAP);
		  shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
			  
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
						"http://localhost:" + this.port + "/shops/shop?shopId="+shopId, Map.class);
				assertEquals(HttpStatus.OK, entity.getStatusCode());	  
		  
	}
	
	/**
	 * Test deletion of shop API	
	 * @throws Exception
	 */
	
	@Test
	public void testDeleteShop() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		  HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		//Invoking the API
		 @SuppressWarnings("unchecked")
		 Map<String, Object> apiResponse =
				  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress= 1901 NW Expressway Street, Oklahoma City, OK 73118, United States&shopNumber=1&shopPostalCode=73118", httpEntity, Map.class, Collections.EMPTY_MAP);
		  String shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		  apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=132 South Avenue, Bloomington, MN 55425, United States&shopNumber=3&shopPostalCode=55425", httpEntity, Map.class, Collections.EMPTY_MAP);
		  shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		  new TestRestTemplate().delete("http://localhost:" + this.port + "/shops/shop?shopId="+shopId);
		
		  ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
					"http://localhost:" + this.port + "/shops/shop?shopId="+shopId, Map.class);
			assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());	 
			
	}

	/**
	 * Test updation of shops API	
	 * @throws Exception
	 */
	
	@Test
	public void testUpdateShop() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		  HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		//Invoking the API
		 @SuppressWarnings("unchecked")
		 Map<String, Object> apiResponse =
				  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress= 132 South Avenue, Bloomington, MN 55425, United States&shopNumber=1&shopPostalCode=55425", httpEntity, Map.class, Collections.EMPTY_MAP);
		  String shopId = apiResponse.get("shopId").toString();
		  assertNotNull(shopId);
		//Invoking the update API
		  ResponseEntity<Map> entity = new TestRestTemplate().exchange("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=1901 NW Expressway Street, Oklahoma City, OK 73118, United States&shopNumber=15&shopPostalCode=73118&shopId=" + shopId,
		      HttpMethod.PUT, httpEntity, String.class, Collections.EMPTY_MAP);
		  assertEquals("true",entity.getBody());
		  entity = new TestRestTemplate().getForEntity(
					"http://localhost:" + this.port + "/shops/shop?shopId="+shopId, Map.class);
		  String shopPostalCode=entity.getBody().get("shopPostalCode").toString();
		  assertEquals("73118", shopPostalCode);
	
	}

	/**
	 * Testing updation of shop which do not exist or is deleted API	
	 * @throws Exception
	 */
	
	@Test
	public void testUpdateException() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		  HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		//Invoking the update API
		 @SuppressWarnings("unchecked")
		 ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
					"http://localhost:" + this.port + "/shops/shop?shopId=13456", Map.class);
		 assertEquals(HttpStatus.NOT_FOUND, entity.getStatusCode());	
	
	}
	
	/**
	 * Test nearest  located of shop API from the given location	
	 * @throws Exception
	 */
	
	@Test
	public void testGetDistance() throws Exception { 
		
		//Building the Request body data
		 // Map<String, Object> requestBody = new HashMap<String, Object>();
		  HttpHeaders requestHeaders = new HttpHeaders();
		  requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		  //Creating http entity object with request body and headers
		  HttpEntity<String> httpEntity =
		      new HttpEntity<String>("", requestHeaders);
		//Invoking the create API
			 @SuppressWarnings("unchecked")
			 Map<String, Object> apiResponse =
					  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=apple store&shopAddress=7021 S Memorial Dr, Tulsa, OK 74133, United States&shopNumber=1&shopPostalCode=74133", httpEntity, Map.class, Collections.EMPTY_MAP);
			  String shopId = apiResponse.get("shopId").toString();
			  assertNotNull(shopId);
			  apiResponse =
						  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=1901 NW Expressway Street, Oklahoma City, OK 73118, United States&shopNumber=2&shopPostalCode=73118", httpEntity, Map.class, Collections.EMPTY_MAP);
			  shopId = apiResponse.get("shopId").toString();
			  assertNotNull(shopId);
				  apiResponse =
						  new TestRestTemplate().postForObject("http://localhost:" + this.port + "/shops/shop?shopName=Apple Store&shopAddress=4529 W 119th St, Leawood, KS 66209, United States&shopNumber=3&shopPostalCode=66209", httpEntity, Map.class, Collections.EMPTY_MAP);
			  shopId = apiResponse.get("shopId").toString();
			  assertNotNull(shopId);
		
		//Invoking the distance  API to get the nearest location of store from the given location
		 @SuppressWarnings("unchecked")
		 ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
					"http://localhost:" + this.port + "/shops/distance?latitude=35.0632284&longitude=-94.8818735", Map.class);
		 System.out.println(entity.getBody());
		 assertEquals(HttpStatus.OK, entity.getStatusCode());
		 String distance=entity.getBody().get("distance").toString();
		  assertEquals("143.33763670107263", distance);
	
	}

}
