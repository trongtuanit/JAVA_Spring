package com.hit.com.hit;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.hit.com.hit.entity.ProductInfo;

/**
 * Hello world!
 *
 */
public class App 
{
	
	private static String getCategoriesURL = "https://computer-shop-hit.herokuapp.com/api/categories";
	private static String getAllProductsURL = "https://computer-shop-hit.herokuapp.com/api/products";
	private static String readAll(Reader rd) throws java.io.IOException {
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	}
	
	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {
	    InputStream is = new URL(url).openStream();
	    try {
	      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
	      String jsonText = readAll(rd);
	      JSONArray jsonArray = new JSONArray(jsonText);
	      return jsonArray;
	    } finally {
	      is.close();
	    }
	 }
	
	
	public static List<String> getAllCategories(String getCategoriesURL) {
		List<String> result = new LinkedList<String>();
		try {
			JSONArray jsonArray = readJsonFromUrl(getCategoriesURL);
			List<JSONObject> listJSON = new LinkedList<JSONObject>();
			for(int i = 0; i < jsonArray.length(); i++) {
				listJSON.add((JSONObject) jsonArray.get(i));
			}
		   
			for(int i = 0; i < listJSON.size(); i++) {
				result.add(listJSON.get(i).toString());
			}
			
			
			
			
			return result;
		} catch (JSONException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static List<ProductInfo> getAllProducts(String getProductsURL) {
		List<ProductInfo> listProductInfo = new LinkedList<ProductInfo>();
		try {
			JSONArray jsonArray = readJsonFromUrl(getProductsURL);
			
			List<JSONObject> listJSON = new LinkedList<JSONObject>();
			
			for(int i = 0; i < jsonArray.length(); i++) {
			  listJSON.add((JSONObject) jsonArray.get(i));
			} 
			List<JSONObject> listProducts = new LinkedList<JSONObject>();
			List<JSONArray> ImageArray = new LinkedList<JSONArray>();
			
			
			for(int i = 0; i < listJSON.size(); i++) {
				listProducts.add(listJSON.get(i).getJSONObject("product"));	
				ImageArray.add(listJSON.get(i).getJSONArray("cloudinaryImage"));
			}
			
	
			for(int i = 0; i < listProducts.size(); i++) {
				ProductInfo productInfo = new ProductInfo();
				productInfo.setProduct(listProducts.get(i).toString());
				List<String> images = new LinkedList<String>();
				
				for(int j = 0; j < ImageArray.get(i).length(); j++) {
					images.add(ImageArray.get(i).getJSONObject(j).toString());
				}
				
				productInfo.setImages(images);
				listProductInfo.add(productInfo);
			}
			
			
			return listProductInfo;
			
			
			
			
		} catch (JSONException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return listProductInfo;
	}
	
    public static void main( String[] args )
    {
    	List<String> categories = getAllCategories(getCategoriesURL);
    	System.out.println("2312");
    	
    	List<ProductInfo> products = getAllProducts(getAllProductsURL);
    	for(int i = 0; i < products.size(); i++) {
    		System.out.println(products.get(i).toString());
    	}
    	System.out.println(123);
        
    }
}
