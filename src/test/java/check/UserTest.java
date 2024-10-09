package check;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.response.Response;
public class UserTest {
	
	 Userpayload user= new Userpayload();
	 Data data= new Data();
	@Test
	public void usertest() throws JsonMappingException, JsonProcessingException
	{
		
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		
	Userpayload desserialiseddata=given().when().get().as(Userpayload.class);
	System.out.println(desserialiseddata.toString());
	System.out.println(desserialiseddata.per_page);
	
	List<Data> list= desserialiseddata.getData();
	for(int i=0;i<list.size();i++)
	{
	
	data= list.get(i);
	System.out.println(data.getEmail());
	
	}
		


}
}
