/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package product;

import java.util.*;

/**
 *
 * @author atlegang dikgale
 */
public class Products {

    // declaring global variables and objects
    int Selection, menuchoice, Index;
    int ProdCodeSize = -1, ProdCatSize = -1, ProdWarrantySize = -1, ProdPriceSize = -1, ProdStockLevelSize = -1, ProdNameSize = -1, ProdSupplierSize = -1;
    boolean Saved;
    Scanner scan = new Scanner(System.in);
    ReportData myObj = new ReportData();
    // declaration of arralists
    ArrayList<Integer> lstProdCode = new ArrayList<>();
    ArrayList<String> lstProdCat = new ArrayList<>();
    ArrayList<Integer> lstProdWarranty = new ArrayList<>();
    ArrayList<Double> lstProdPrice = new ArrayList<>();
    ArrayList<Integer> lstProdStockLevel = new ArrayList<>();
    ArrayList<String> lstProdName = new ArrayList<>();
    ArrayList<String> lstProdSupplier = new ArrayList<>();

    /*
   USE THIS TO POPULATE ARRAYLISTS TO TEST OTHER METHODS
    
    public void LoadArrayLists() {
        lstProdCode.add(123);
        lstProdCat.add("Laptop");
        lstProdWarranty.add(6);
        lstProdPrice.add(18723.02);
        lstProdStockLevel.add(3);
        lstProdName.add("Lenovo");
        lstProdSupplier.add("Embacadero");

        lstProdCode.add(124);
        lstProdCat.add("Gaming console");
        lstProdWarranty.add(6);
        lstProdPrice.add(130000.00);
        lstProdStockLevel.add(2);
        lstProdName.add("Play Station ");
        lstProdSupplier.add("Sony");

    }*/

    private void ExitOption() {

        System.out.println("Please enter 1 to display menu or any key to exit");
        menuchoice = scan.nextInt();
        if (menuchoice == 1) {
            Menu();
        } else {
            ExitApplication();
        }
    }

    public void Menu() {
        // options of actions that user can perform

        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        System.out.println("Enter(1) to launch the menu or any key to exit ");
        int choice = scan.nextInt();
        if (choice == 1) {
            System.out.println("PLaese select 1 item below: ");
            System.out.println("");
            System.out.println("(1) Caputure a new product");
            System.out.println("(2) Search for a product");
            System.out.println("(3) Update a product");
            System.out.println("(4) Delete a product");
            System.out.println("(5) Exit Application");
            Selection = scan.nextInt();

        }
        if (Selection == 1) {
             CaptureProduct();
        } else {
            if (Selection == 2) {
                SearchProduct();
            } else {
                if (Selection == 3) {
                    UpdateProduct();
                } else {
                    if (Selection == 4) {
                        DeleteProduct();
                    } else {
                        if (Selection == 5) {
                            ExitApplication();//6th selection option to quiet the app
                        }
                    }
                }
            }
        }

    }//end of menu

    private void ArrayListSizeCheck() {
        ProdCodeSize = lstProdCode.size();
        ProdCatSize = lstProdCat.size();
        ProdWarrantySize = lstProdWarranty.size();
        ProdPriceSize = lstProdPrice.size();
        ProdStockLevelSize = lstProdStockLevel.size();
        ProdNameSize = lstProdName.size();
        ProdSupplierSize = lstProdSupplier.size();
    }

    public void CaptureProduct() {
        do {
            // calling the method that will allocate the element of last entry
            ArrayListSizeCheck();
            // prompting user for input and reading into all arraylists
            System.out.println("Please enter the product code: ");
            myObj.setProductCode(scan.nextInt());
            ProdCodeSize = ProdCodeSize++;
            lstProdCode.add((ProdCodeSize), myObj.getProductCode());

            System.out.println("Please enter the product name: ");
            myObj.setProductName(scan.nextLine());
            ProdNameSize = ProdNameSize++;
            lstProdName.add((ProdNameSize), myObj.getProductName());

            System.out.println("Please enter a number that coresponse with the category of the product: ");
            System.out.println("*************************************************************************");
            System.out.println("Desktop Computer = (1) ");
            System.out.println("Laptop = (2) ");
            System.out.println("Tablet = (3) ");
            System.out.println("Printer = (4) ");
            System.out.println("Gaming Console = (5)");
            int CatChoice = scan.nextInt();
            String Catchoice = " ";
            switch(CatChoice){
             case 1: 
                Catchoice = "Desktop Computer";
             break;  
            case 2: 
                Catchoice = "Laptop";
             break; 
             case 3: 
                 Catchoice = "Tablet";
             break;
             case 4: 
                Catchoice = "Printer";
             break;
             case 5:
                 Catchoice = "Gaming Console";
             break;
                 
        }
             

            myObj.setProductCat(Catchoice);
            ProdCatSize = ProdCatSize++;
            lstProdCat.add((ProdCatSize), myObj.getProductCat());

            System.out.println("Please enter the price of the product: ");
            myObj.setProductPrice(scan.nextDouble());
            ProdPriceSize = ProdPriceSize++;
            lstProdPrice.add((ProdPriceSize), myObj.getProductPrice());

            System.out.println("Please indicate the products warranty. Enter (1) "
                    + "for 6 months warranty and any other key for a 2 year warranty");
            int warranty, warnLength;
            warranty = scan.nextInt();
            if (warranty == 1) {
                warnLength = 6;
            } else {
                warnLength = 2;
            }
            myObj.setProductWarranty(warnLength);
            ProdWarrantySize = ProdWarrantySize++;
            lstProdWarranty.add((ProdWarrantySize), myObj.getProductWarranty());

            System.out.println("Please enter stock level for " + myObj.getProductName());
            myObj.setProductStockLevel(scan.nextInt());
            ProdStockLevelSize = ProdStockLevelSize++;
            lstProdStockLevel.add((ProdStockLevelSize), myObj.getProductStockLevel());

            System.out.println("Please enter the name of the supplier for " + myObj.getProductName());
            myObj.setProductSupplier(scan.next());
            ProdSupplierSize = ProdSupplierSize++;
            lstProdSupplier.add((ProdSupplierSize), myObj.getProductSupplier());

            ExitOption();
        } while (menuchoice == 1);
        if (SaveProduct(Saved)) {
            System.out.println("Product details upated successfully");
        }

    }

    private boolean SaveProduct(boolean Saved) {
        //verify that element exists in the arraylist
        ArrayListSizeCheck();
        return Saved = lstProdCode.contains(ProdCodeSize);

    }

    public void SearchProduct() {
        ArrayListSizeCheck();
        boolean Ans;
        System.out.println("Please enter the product code for the product you would like to search");
        int Search = scan.nextInt();
        Ans = lstProdCode.contains(Search);

        if (Ans) {
            Index = lstProdCode.indexOf(Search);
            System.out.println("*************************************************************************");
            System.out.println("\nPRODUCT SEARCH RESULT");
            System.out.println("\n*************************************************************************\n");
            System.out.println("PRODUCT CODE: \t" + lstProdCode.get(Index));
            System.out.println("PRODUCT CATEGORY: \t" + lstProdCat.get(Index));
            System.out.println("PRODUCT WARRANTY: \t" + lstProdWarranty.get(Index));
            System.out.println("PRODUCT PRICE:\t" + lstProdPrice.get(Index));
            System.out.println("PRODUCT STOCK LEVEL :\t" + lstProdStockLevel.get(Index));
            System.out.println("PRODUCT NAME:\t" + lstProdName.get(Index));
            System.out.println("PRODUCT SUPPLEIR:\t" + lstProdSupplier.get(Index));

        } else {
            System.out.println("The product you attempted to search doesnot exits. Invalid product search ");
        }

        ExitOption();

    }

    public void UpdateProduct() {
        boolean Ans;
        System.out.println("Please enter the product code for the product you would like to update: ");
        Ans = lstProdCode.contains(scan.nextInt());
        if (Ans) {
            Index = lstProdCode.indexOf(scan.nextInt());
        }

        System.out.println("Would you like to update the warranty of a product, yes(y) or no(n) ");
        String UpdateWarranty = scan.nextLine().toUpperCase();
        if (UpdateWarranty.equals("Y")) {
            System.out.println("Enter new product warranty>> ");
            myObj.setProductWarranty(scan.nextInt());
            lstProdWarranty.add(Index, myObj.getProductWarranty());
        }

        System.out.println("Would you like to update the price of a product, yes(y) or no(n) ");
        String UpdateProdPrice = scan.next().toUpperCase();
        if (UpdateProdPrice.equals("Y")) {
            System.out.println("Enter new product price>> ");
            myObj.setProductPrice(scan.nextDouble());
            lstProdPrice.add(Index, myObj.getProductPrice());
        }

        System.out.println("Would you like to update the stock level of a product, yes(y) or no(n) ");
        String UpdateStockLevel = scan.next().toUpperCase();
        if (UpdateStockLevel.equals("Y")) {
            System.out.println("Enter ne stock level");
            myObj.setProductStockLevel(scan.nextInt());
            lstProdStockLevel.add(Index, myObj.getProductStockLevel());
        }

        System.out.println("Product details upated successfully");

        ExitOption();
    }

    public void DeleteProduct() {
        int IndexToDelete = 0;
        System.out.println("Which product would you like to delete");
        int toDelete = Integer.parseInt(scan.next());
        System.out.println("Are you sure you want to delete " + toDelete + " yes (1) or press any number for no");
        int Delete = scan.nextInt();
        boolean Ans;
        Ans = lstProdCode.contains(toDelete);
        if (Ans) {
            IndexToDelete = lstProdCode.indexOf(toDelete);
        }

        if (Delete == 1) {
            lstProdCode.remove(IndexToDelete);
            lstProdCat.remove(IndexToDelete);
            lstProdWarranty.remove(IndexToDelete);
            lstProdPrice.remove(IndexToDelete);
            lstProdStockLevel.remove(IndexToDelete);
            lstProdName.remove(IndexToDelete);
            lstProdSupplier.remove(IndexToDelete);
            System.out.println(toDelete + " successfully deleted from memory");
        }
        ExitOption();
    }

    private void ExitApplication() {
        System.exit(0);
    }

}
