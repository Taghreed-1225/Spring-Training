package com.adminPanel.app.controller;

import com.adminPanel.app.exception.BadRequestException;
import com.adminPanel.app.exception.ProductExceptionHandler;
import com.adminPanel.app.model.JsonPlaceHolderModel;
import com.adminPanel.app.model.Product;
import com.adminPanel.app.model.ProductDetails;
import com.adminPanel.app.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@Api(tags = "this is documentation for products APIs")
public class HomeControllerDeprecated
{
 @Autowired
 private ProductService productService;

//ToDo valid
 @PostMapping("/products")
 public ProductDetails insertProducts( @RequestBody  ProductDetails productDetails) throws BadRequestException {

 return productService.insert(productDetails);
 }


 @PutMapping("/products")
 public   ProductDetails updateProducts(@RequestBody ProductDetails productDetails)
 {
  return productService.update(productDetails);
 }

@DeleteMapping("/products")
 public void deleteProduct( @RequestParam("id") int tid)
 {
  productService.deleteById(tid);
 }

//ToDo
// @GetMapping("/products/productDetails")// use nesting
// public ProductDetails getProductDetailsByProductId( @RequestParam("productId") int id)
// {
//  ProductDetails productDetails=new ProductDetails();
//  productDetails=productService.findByProductId(id);
//
//  return productDetails;
// }

 @GetMapping("/products")
 @ApiOperation(value = "this api will get product by id")
 @ApiResponses(value = {@ApiResponse(code = 200 , message = "this is the succesful responce when we find the producr") ,
         @ApiResponse(code = 500 , message = "this is the failed responce something wrong from server")
 })
 public Product getProductById( @RequestParam("productId") int id) throws ProductExceptionHandler {
return productService.findById(id);
 }

//ToDo
// @GetMapping("/searchProduct")
// public String searchProducts(@RequestParam("searchKey") String searchKey , Model productModel)
// {
//  System.out.println("hello from search");
//  System.out.println(searchKey);
//  List<Product> productList = productService.findByName(searchKey);
//  productModel.addAttribute("productList" , productList);
//  System.out.println("list = "+productList);
//  return "homePage";
// }

//ToDo get all min 1:02:34

//هترجع string بدل json
 @GetMapping("/callingAnotherAPI")
 public String getTitle(){
 RestTemplate restTemplate= new RestTemplate();
 String url="https://jsonplaceholder.typicode.com/posts/1";
 String title = restTemplate.getForObject(url ,String.class);//(url, نوع الكلاس بتاع الريسبونس)
return title;

 }
 //لو عاوزاه يرجع json هعمل كلاس فيه الاتربيوت JsonPlaceHolderModel
 @GetMapping("/callingAnotherAPI2")
 public JsonPlaceHolderModel getTitle2(){
  RestTemplate restTemplate= new RestTemplate();
  String url="https://jsonplaceholder.typicode.com/posts/1";
 JsonPlaceHolderModel response = restTemplate.getForObject(url ,JsonPlaceHolderModel.class);//(url, نوع الكلاس بتاع الريسبونس)

  return response;

 }
 @GetMapping("/callingAnotherAPI4")
 public ResponseEntity<JsonPlaceHolderModel> getTitle4(){
  RestTemplate restTemplate= new RestTemplate();
  String url="https://jsonplaceholder.typicode.com/posts/1";
  //(url, نوع الكلاس بتاع الريسبونس)
  ResponseEntity<JsonPlaceHolderModel>  response = restTemplate.getForEntity(url ,JsonPlaceHolderModel.class);
  return response;}



 //لو عايزة ارجع الbody سترينج , دا فاريابل
 @GetMapping("/callingAnotherAPI3")
 public String getTitle3(){
  RestTemplate restTemplate= new RestTemplate();
  String url="https://jsonplaceholder.typicode.com/posts/1";
  JsonPlaceHolderModel response = restTemplate.getForObject(url ,JsonPlaceHolderModel.class);//(url, نوع الكلاس بتاع الريسبونس)
  return response.getBody();

 }










}
