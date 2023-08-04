package table.data.example;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.LazyDataModel;

@ManagedBean(name = "tableDataBean")
@SessionScoped
public class TableDataBean {
	private LazyDataModel<Customer> customers;
	
	@PostConstruct
	public void init() {      
		customers = new LazyCustomerDataModel(new CustomerService().getCustomers(2000));
	}
	
	public LazyDataModel<Customer> getCustomers() {
		return customers;
	}
}
