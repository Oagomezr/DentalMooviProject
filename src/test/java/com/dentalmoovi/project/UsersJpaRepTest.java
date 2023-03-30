package com.dentalmoovi.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.dentalmoovi.project.model.*;
import com.dentalmoovi.project.repository.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class UsersJpaRepTest {
    
    @Autowired
    public void repositoriesInyected(IUserRep userRep, IProductsRep productsRep, ICartRep cartRep, IRolesRep rolesRep,
            IActionsRep actionsRep, IModulesRep modulesRep, IDomicilesRep domicilesRep, IPaymentMethodRep paymentMethodRep,
            IOrdersRep ordersRep, IOrderDetailsRep orderDetailsRep) {
        this.userRep = userRep;
        this.productsRep = productsRep;
        this.cartRep = cartRep;
        this.rolesRep = rolesRep;
        this.actionsRep = actionsRep;
        this.modulesRep = modulesRep;
        this.domicilesRep = domicilesRep;
        this.paymentMethodRep=paymentMethodRep;
        this.ordersRep=ordersRep;
        this.orderDetailsRep=orderDetailsRep;
    }

    @Test
    public void saveUser(){

        //-->PaymentMethod
        PaymentMethod credit = new PaymentMethod("credit");
        PaymentMethod debit = new PaymentMethod("debit");

        credit=paymentMethodRep.save(credit);
        debit=paymentMethodRep.save(debit);
        //<--PaymentMethod

        //-->Module
        Modules products = new Modules("products");
        products = modulesRep.save(products);
        //<--Module

        //-->Actions
        Actions create = new Actions('C',products);
        Actions read = new Actions('R',products);
        Actions update = new Actions('U',products);
        Actions delete = new Actions('D',products);

        create=actionsRep.save(create);
        read=actionsRep.save(read);
        update=actionsRep.save(update);
        delete=actionsRep.save(delete);
        //<--Actions

        //-->Roles
        Roles admin = new Roles("administrador");
        Roles employee = new Roles("empleado");

        admin.getActions().add(create);
        admin.getActions().add(read);
        admin.getActions().add(update);
        admin.getActions().add(delete);

        employee.getActions().add(read);
        employee.getActions().add(update);

        admin = rolesRep.save(admin);
        employee = rolesRep.save(employee);
        //<--Roles

        //-->Users
        Users maria = new Users("maria", "rodriguez", "1234", "32021", "Bogota", admin);
        Users mario = new Users("mario", "rodriguez", "1234", "3202148944", "Bogota", employee);

        maria=userRep.save(maria);
        mario=userRep.save(mario);
        //<--Users

        //-->Domiciles
        Domiciles dom1 = new Domiciles("cra 12 n 160-2", "3215403995", "cundinamarca", "Bogotá", maria);
        Domiciles dom2 = new Domiciles("cra 12 n 160-2", "3215403295", "cundinamarca", "Bogotá", mario);
        dom1=domicilesRep.save(dom1);
        dom2=domicilesRep.save(dom2);
        //<--Domiciles

        //-->Products
        Products arcos = new Products("arcos23", 1320.3, 1200, "aduas", "inv123", LocalDate.parse("2022-01-23"));
        Products brakets = new Products("brakets", 1320.3, 1200, "adudas", "inv456", LocalDate.parse("2022-01-23"));

        productsRep.save(arcos);
        productsRep.save(brakets);
        //<--Products

        //-->Cart
        Cart shopCart1 = new Cart(12, maria, arcos);
        Cart shopCart2 = new Cart(14, mario, brakets);

        cartRep.save(shopCart1);
        cartRep.save(shopCart2);
        //<--Cart

        //-->Orders
        Orders orderone = new Orders(3000.000, LocalDate.now(), LocalDate.now(), maria, credit, dom1);
        Orders ordertwo = new Orders(3000.000, LocalDate.now(), LocalDate.now(), mario, debit, dom2);

        orderone = ordersRep.save(orderone);
        ordertwo = ordersRep.save(ordertwo);
        //<--Orders

        //-->OrderDetails
        OrderDetails orderoneD= new OrderDetails(15, 10.000, orderone, arcos);
        OrderDetails ordertwoD= new OrderDetails(15, 10.000, ordertwo, brakets);

        orderoneD=orderDetailsRep.save(orderoneD);
        ordertwoD=orderDetailsRep.save(ordertwoD);
        //<--OrderDetails

        //-->Send database
        userRep.flush();
        productsRep.flush();
        cartRep.flush();
        rolesRep.flush();
        actionsRep.flush();
        modulesRep.flush();
        domicilesRep.flush();
        paymentMethodRep.flush();
        orderDetailsRep.flush();
        //<--Send database

        //-->Test
        assertEquals(2, userRep.findAll().size());
        assertEquals(2, productsRep.findAll().size());
        assertEquals(2, cartRep.findAll().size());
        assertEquals(2, rolesRep.findAll().size());
        assertEquals(4, actionsRep.findAll().size());
        assertEquals(1, modulesRep.findAll().size());
        assertEquals(2, domicilesRep.findAll().size());
        assertEquals(2, paymentMethodRep.findAll().size());
        assertEquals(2, orderDetailsRep.findAll().size());
        //<--Test
    }

    private IUserRep userRep;
    private IProductsRep productsRep;
    private ICartRep cartRep;
    private IRolesRep rolesRep;
    private IActionsRep actionsRep;
    private IModulesRep modulesRep;
    private IDomicilesRep domicilesRep;
    private IPaymentMethodRep paymentMethodRep;
    private IOrdersRep ordersRep;
    private IOrderDetailsRep orderDetailsRep;
}
