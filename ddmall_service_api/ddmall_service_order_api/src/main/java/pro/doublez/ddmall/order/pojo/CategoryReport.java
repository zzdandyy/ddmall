package pro.doublez.ddmall.order.pojo;


import java.util.Date;

public class CategoryReport {

	private Integer categoryId1;
	private Integer categoryId2;
	private Integer categoryId3;
	private Date countDate;
	private Integer num;
	private Integer money;


	//get方法
	public Integer getCategoryId1() {
		return categoryId1;
	}

	//set方法
	public void setCategoryId1(Integer categoryId1) {
		this.categoryId1 = categoryId1;
	}
	//get方法
	public Integer getCategoryId2() {
		return categoryId2;
	}

	//set方法
	public void setCategoryId2(Integer categoryId2) {
		this.categoryId2 = categoryId2;
	}
	//get方法
	public Integer getCategoryId3() {
		return categoryId3;
	}

	//set方法
	public void setCategoryId3(Integer categoryId3) {
		this.categoryId3 = categoryId3;
	}
	//get方法
	public Date getCountDate() {
		return countDate;
	}

	//set方法
	public void setCountDate(Date countDate) {
		this.countDate = countDate;
	}
	//get方法
	public Integer getNum() {
		return num;
	}

	//set方法
	public void setNum(Integer num) {
		this.num = num;
	}
	//get方法
	public Integer getMoney() {
		return money;
	}

	//set方法
	public void setMoney(Integer money) {
		this.money = money;
	}


}
