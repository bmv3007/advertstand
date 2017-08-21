package dto;

/**
 * Created by Maria on 19.08.2017.
 */
public class ProductDTO implements java.io.Serializable {

    static final long serialVersionUID = 3260689382642549142L;


    private Long id;


    private String name;


    private Category category;


    private String description;


    private float price;


    private boolean vegetarian;


    private int weight;


    private int quantity;


    private String image;

    public ProductDTO() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

    //    @Transient
//    private MultipartFile fileHolder;

//    @OneToMany(mappedBy = "product")
//    public List<OrdersProducts> orders_products;
}