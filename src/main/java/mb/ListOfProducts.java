package mb;

import dto.ProductDTO;
import service.ws.ProductWSClient;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Maria on 19.08.2017.
 */
@ManagedBean(name = "products")
@RequestScoped
public class ListOfProducts {

    @Inject
    private ProductWSClient productWSClient;


    private List<ProductDTO> listOfProducts;

    public ListOfProducts() {
    }

    public List<ProductDTO> getListOfProducts() {
        return listOfProducts;
    }

    public void setListOfProducts(List<ProductDTO> listOfProducts) {
        this.listOfProducts = listOfProducts;
        System.out.println("listOfProducts = "+listOfProducts.size());
    }

    @PostConstruct
    public void loadListOfProducts() {
        setListOfProducts(productWSClient.loadProductsJson());
        System.out.println("loadListOfProducts");
    }

}
