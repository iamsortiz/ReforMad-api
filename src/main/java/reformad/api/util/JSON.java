package reformad.api.util;

import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON {

	private static ObjectMapper mapper = new ObjectMapper();

	public static String encode(Object o) {
		String json = "";

		// TODO Fill autogenerated catchs or use a generic one
		try {
			json = mapper.writeValueAsString(o);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e.toString(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.toString(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.toString(), e);
		}

		return json;
	}

	public static Object decode(String JSON, Class<?> c) {

		Object o = null;

		// TODO Fill autogenerated catchs or use a generic one
		try {
			o = mapper.readValue(JSON, c);
		} catch (JsonGenerationException e) {
			throw new RuntimeException(e.toString(), e);
		} catch (JsonMappingException e) {
			throw new RuntimeException(e.toString(), e);
		} catch (IOException e) {
			throw new RuntimeException(e.toString(), e);
		}

		return o;
	}

	public static HashMap<String, Object> decodeToHash(String JSON) {

		HashMap<String, Object> o = new HashMap<String, Object>();

		JsonFactory factory = new JsonFactory();
		ObjectMapper mapper = new ObjectMapper(factory);
		TypeReference<HashMap<String, Object>> typeRef = new TypeReference<HashMap<String, Object>>() {
		};

		try {
			o = mapper.readValue(JSON, typeRef);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("JSON.decodeToHash = " + o);

		return o;
	}
}
