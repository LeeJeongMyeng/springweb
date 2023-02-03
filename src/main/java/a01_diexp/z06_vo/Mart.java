package a01_diexp.z06_vo;

import org.springframework.beans.factory.annotation.Autowired;

public class Mart {
 private String tname;
 
 @Autowired
 private Product product;

 public void Martinfo() {
	 System.out.println("["+tname+"정보]");
	 product.prodinfo();
 }
 
 
public Mart() {
}

public Mart(String tname) {
	this.tname = tname;
}

public String getTname() {
	return tname;
}

public void setTname(String tname) {
	this.tname = tname;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}
	
	
}
