package a01_diexp.z06_vo;

import org.springframework.stereotype.Component;

@Component
public class Product {
	   private String product;
	   private int price;
	   private int cnt;
	   
	   public void prodinfo() {
		   System.out.println("[물건정보]");
		   if(product!=null) {
			   System.out.println("물건명:"+product);
			   System.out.println("가격:"+price);
			   System.out.println("갯수:"+cnt);
		   }else {
			   System.out.println("없음");
		   }
	   }
	   
	   public String getProduct() {
	      return product;
	   }
	   public void setProduct(String product) {
	      this.product = product;
	   }
	   public int getPrice() {
	      return price;
	   }
	   public void setPrice(int price) {
	      this.price = price;
	   }
	   public int getCnt() {
	      return cnt;
	   }
	   public void setCnt(int cnt) {
	      this.cnt = cnt;
	   }
	   public Product(String product, int price, int cnt) {
	      this.product = product;
	      this.price = price;
	      this.cnt = cnt;
	   }
	   public Product() {
	      super();
	      // TODO Auto-generated constructor stub
	   }
	}