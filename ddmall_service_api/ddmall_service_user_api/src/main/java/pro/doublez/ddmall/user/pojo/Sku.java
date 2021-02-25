package pro.doublez.ddmall.user.pojo;


import java.util.Date;

public class Sku {

	private Long id;
	private String sn;
	private String name;
	private Integer price;
	private Integer num;
	private Integer alertNum;
	private String image;
	private String images;
	private Integer weight;
	private Date createTime;
	private Date updateTime;
	private Long spuId;
	private Integer categoryId;
	private String categoryName;
	private String brandName;
	private String spec;
	private Integer saleNum;
	private Integer commentNum;
	private String status;


	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getSn() {
		return sn;
	}

	//set方法
	public void setSn(String sn) {
		this.sn = sn;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
	}
	//get方法
	public Integer getPrice() {
		return price;
	}

	//set方法
	public void setPrice(Integer price) {
		this.price = price;
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
	public Integer getAlertNum() {
		return alertNum;
	}

	//set方法
	public void setAlertNum(Integer alertNum) {
		this.alertNum = alertNum;
	}
	//get方法
	public String getImage() {
		return image;
	}

	//set方法
	public void setImage(String image) {
		this.image = image;
	}
	//get方法
	public String getImages() {
		return images;
	}

	//set方法
	public void setImages(String images) {
		this.images = images;
	}
	//get方法
	public Integer getWeight() {
		return weight;
	}

	//set方法
	public void setWeight(Integer weight) {
		this.weight = weight;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public Long getSpuId() {
		return spuId;
	}

	//set方法
	public void setSpuId(Long spuId) {
		this.spuId = spuId;
	}
	//get方法
	public Integer getCategoryId() {
		return categoryId;
	}

	//set方法
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	//get方法
	public String getCategoryName() {
		return categoryName;
	}

	//set方法
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	//get方法
	public String getBrandName() {
		return brandName;
	}

	//set方法
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	//get方法
	public String getSpec() {
		return spec;
	}

	//set方法
	public void setSpec(String spec) {
		this.spec = spec;
	}
	//get方法
	public Integer getSaleNum() {
		return saleNum;
	}

	//set方法
	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}
	//get方法
	public Integer getCommentNum() {
		return commentNum;
	}

	//set方法
	public void setCommentNum(Integer commentNum) {
		this.commentNum = commentNum;
	}
	//get方法
	public String getStatus() {
		return status;
	}

	//set方法
	public void setStatus(String status) {
		this.status = status;
	}


}
