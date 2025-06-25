import java.time.LocalDate;
import java.util.*;
class ArrayCourseWorkNew{
    //-------------Craete Arrays---------------------//
    public static String []idArray=new String[0];
    public static String []nameArray=new String[0];
    public static String []phoneArray=new String[0];
    public static String []companyArray=new String[0];
    public static double []salatyArray=new double[0];
    public static String []birthdayArray=new String[0];
    //--------------Clear Console Method--------------//
    public final static void clearConsole() {
        try {
                final String os = System.getProperty("os.name");
                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                }
        } catch (final Exception e) {
                    e.printStackTrace();
                    // Handle any exceptions.
                }
        }
        //------------Home Page Method-------------//
    public static void homePage(){
        Scanner input=new Scanner(System.in);
        System.out.println("==============Ifreind Contact Organizer====================");
        System.out.println("\n[1] Add Contacts");
        System.out.println("\n[2] Update Contacts");
        System.out.println("\n[3] Delete Contacts");
        System.out.println("\n[4] Search Contacts");
        System.out.println("\n[5] List Contacts");
        System.out.println("\n[6] Exit");
        System.out.print("\nEnter You option to Continue --->");
        int option=input.nextInt();
        switch (option) {
            case 1:
                clearConsole();
                addContacts();
                break;
        
            case 2:
                clearConsole();
                updateContacts();
                break;
            case 3:
                clearConsole();
                deleteContacts();
                break;
            case 4:
                clearConsole();
                searchContacts();
                break;
            case 5:
                clearConsole();
                listContacts();
                break;
            case 6:
                exit();
                 break;
            default:
                System.out.println("\nInvalid Option Input !");
                break;
        }
    }
    //--------------List Contacts Method-----------//
    public static void listContacts(){
        Scanner input=new Scanner(System.in);
        System.out.println("================List Contacts==============");
        System.out.println("\n[1] Sorting by Name");
        System.out.println("\n[2] Sorting by Salary");
        System.out.println("\n[3] Sorting by Birthday");
        System.out.println("\n[4]Exit");
        System.out.print("\nEnter Option ->>>");
        int option=input.nextInt();
        switch (option) {
            case 1:
                nameSot();
                break;
        
             case 2:
                salarySot();
                break;
            case 3:
                birthDaySot();
                break;
            case 4:
                exit();
                homePage();
                break;
            default:
                System.out.println("\nThis is not a valid input !");
                break;
        }
        
    }
    //----------BirthDay sort Method--------//
    public static void birthDaySot(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("================List Contacts By Birth Day================");
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("| Contact Id |   Name  |  Phone Number  |  Company  |  Salary  |  Birthday  |");
            System.out.println("+---------------------------------------------------------------------------+");
            birthSort();
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go home page (Y / N) : ");
            char ch=input.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                clearConsole();
                homePage();
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                listContacts();
            }
        }while(true);
    }
    //---------Birthday Sort Method--------//
    public static void birthSort(){
        String[] tempIdArray=new String[idArray.length];
        String[] tempNameArray=new String[idArray.length];
        String[] tempPhoneArray=new String[idArray.length];
        String[] tempComArray=new String[idArray.length];
        double[] tempSalArray=new double[idArray.length];
        String[] tempBirthDayArray=new String[idArray.length];

        for(int i=0;i<idArray.length;i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneArray[i]=phoneArray[i];
            tempComArray[i]=companyArray[i];
            tempSalArray[i]=salatyArray[i];
            tempBirthDayArray[i]=birthdayArray[i];
        }

        for(int j=1;j<idArray.length;j++){
            for(int i=0;i<idArray.length-j;i++){
                if(tempBirthDayArray[i].compareTo(tempBirthDayArray[i+1])>0){
                    String tempBirthDay=tempBirthDayArray[i];
                    tempBirthDayArray[i]=tempBirthDayArray[i+1];
                    tempBirthDayArray[i+1]=tempBirthDay;

                    String tempId=tempIdArray[i];
                    tempIdArray[i]=tempIdArray[i+1];
                    tempIdArray[i+1]=tempId;

                    String tempPhone=tempPhoneArray[i];
                    tempPhoneArray[i]=tempPhoneArray[i+1];
                    tempPhoneArray[i+1]=tempPhone;

                    String tempCom=tempComArray[i];
                    tempComArray[i]=tempComArray[i+1];
                    tempComArray[i+1]=tempCom;

                    double tempSal=tempSalArray[i];
                    tempSalArray[i]=tempSalArray[i+1];
                    tempSalArray[i+1]=tempSal;

                    String tempName=tempNameArray[i];
                    tempNameArray[i]=tempNameArray[i+1];
                    tempNameArray[i+1]=tempName;
                }
            }
            for(int i=0;i<idArray.length;i++){
                System.out.printf("| %-12s| %-12s| %-12s| %-12s|%-12s| %-12s|\n",
                tempIdArray[i],tempNameArray[i],tempPhoneArray[i],
                tempComArray[i],tempSalArray[i],tempBirthDayArray[i]);
            }
        }
    }
    //----------sorting by name-------------//
    public static void nameSot(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("================List Contacts By Name================");
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("| Contact Id |   Name  |  Phone Number  |  Company  |  Salary  |  Birthday  |");
            System.out.println("+---------------------------------------------------------------------------+");
            nameSort();
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go home page (Y / N) : ");
            char ch=input.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                clearConsole();
                homePage();
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                listContacts();
            }
        }while(true);
    }
    //-------------name sort method-------//
    public static void nameSort(){
        String[] tempIdArray=new String[idArray.length];
        String[] tempNameArray=new String[idArray.length];
        String[] tempPhoneArray=new String[idArray.length];
        String[] tempComArray=new String[idArray.length];
        double[] tempSalArray=new double[idArray.length];
        String[] tempBirthDayArray=new String[idArray.length];

        for(int i=0;i<idArray.length;i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneArray[i]=phoneArray[i];
            tempComArray[i]=companyArray[i];
            tempSalArray[i]=salatyArray[i];
            tempBirthDayArray[i]=birthdayArray[i];
        }

        for(int j=1;j<idArray.length;j++){
            for(int i=0;i<idArray.length-j;i++){
                if(tempNameArray[i].compareTo(tempNameArray[i+1])>0){
                    String tempName=tempNameArray[i];
                    tempNameArray[i]=tempNameArray[i+1];
                    tempNameArray[i+1]=tempName;

                    String tempId=tempIdArray[i];
                    tempIdArray[i]=tempIdArray[i+1];
                    tempIdArray[i+1]=tempId;

                    String tempPhone=tempPhoneArray[i];
                    tempPhoneArray[i]=tempPhoneArray[i+1];
                    tempPhoneArray[i+1]=tempPhone;

                    String tempCom=tempComArray[i];
                    tempComArray[i]=tempComArray[i+1];
                    tempComArray[i+1]=tempCom;

                    double tempSal=tempSalArray[i];
                    tempSalArray[i]=tempSalArray[i+1];
                    tempSalArray[i+1]=tempSal;

                    String tempBirthDay=tempBirthDayArray[i];
                    tempBirthDayArray[i]=tempBirthDayArray[i+1];
                    tempBirthDayArray[i+1]=tempBirthDay;
                }
            }
            for(int i=0;i<idArray.length;i++){
                System.out.printf("| %-12s| %-12s| %-12s| %-12s|%-12s| %-12s|\n",
                tempIdArray[i],tempNameArray[i],tempPhoneArray[i],
                tempComArray[i],tempSalArray[i],tempBirthDayArray[i]);
            }
        }
    }
    //----------Sirting by Salary-----------//
    public static void salarySot(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("================List Contacts By Salary================");
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.println("| Contact Id |   Name  |  Phone Number  |  Company  |  Salary  |  Birthday  |");
            System.out.println("+---------------------------------------------------------------------------+");
            salSort();
            System.out.println("+---------------------------------------------------------------------------+");
            System.out.print("\nDo you want to go home page (Y / N) : ");
            char ch=input.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                clearConsole();
                homePage();
            }else if(ch=='N' || ch=='n'){
                clearConsole();
                listContacts();
            }
        }while(true);
    }
    //------------Salary sort------------------//
    public static void salSort(){
        String[] tempIdArray=new String[idArray.length];
        String[] tempNameArray=new String[idArray.length];
        String[] tempPhoneArray=new String[idArray.length];
        String[] tempComArray=new String[idArray.length];
        double[] tempSalArray=new double[idArray.length];
        String[] tempBirthDayArray=new String[idArray.length];

        for(int i=0;i<salatyArray.length;i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneArray[i]=phoneArray[i];
            tempComArray[i]=companyArray[i];
            tempSalArray[i]=salatyArray[i];
            tempBirthDayArray[i]=birthdayArray[i];
        }

        for(int j=1;j<idArray.length;j++){
            for(int i=0;i<idArray.length-j;i++){
                if(tempSalArray[i]>tempSalArray[i+1]){
                    double tempSal=tempSalArray[i];
                    tempSalArray[i]=tempSalArray[i+1];
                    tempSalArray[i+1]=tempSal;

                    String tempId=tempIdArray[i];
                    tempIdArray[i]=tempIdArray[i+1];
                    tempIdArray[i+1]=tempId;

                    String tempPhone=tempPhoneArray[i];
                    tempPhoneArray[i]=tempPhoneArray[i+1];
                    tempPhoneArray[i+1]=tempPhone;

                    String tempCom=tempComArray[i];
                    tempComArray[i]=tempComArray[i+1];
                    tempComArray[i+1]=tempCom;

                    String tempName=tempNameArray[i];
                    tempNameArray[i]=tempNameArray[i+1];
                    tempNameArray[i+1]=tempName;

                    String tempBirthDay=tempBirthDayArray[i];
                    tempBirthDayArray[i]=tempBirthDayArray[i+1];
                    tempBirthDayArray[i+1]=tempBirthDay;
                }
            }
            for(int i=0;i<idArray.length;i++){
                System.out.printf("| %-12s| %-12s| %-12s| %-12s|%-12s| %-12s|\n",
                tempIdArray[i],tempNameArray[i],tempPhoneArray[i],
                tempComArray[i],tempSalArray[i],tempBirthDayArray[i]);
            }
        }
    }
    //------------Exit Method------------------//
    public static void exit(){
        System.exit(0);
    }
    //-----------Delete Contacts Method---------//
    public static void deleteContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("===============Delete Contacts==========");
            System.out.print("\n Delete Contact By Name Or Contact Number :");
            String nameOrPhone=input.nextLine();
            int index=searchByNameOrPhone(nameOrPhone);
            if(index==-1){
                System.out.println("\nNo contact Found");
                System.out.print("\nDo you want to try a new serch (y / N) : ");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    homePage();
                }
            }else{
                printDetails(index);
                L1:do{
                    System.out.println("\n Do you want to delete this contact (Y /N) :");
                    char ch=input.next().charAt(0);
                    if(ch=='Y' || ch=='y'){
                        delete(index);
                        System.out.println("\nDelete is Completed ");
                        break L1;
                    }else if(ch=='N' || ch=='n'){
                        break L1;
                    }
                }while(true);
                System.out.print("\nDo you want to Delete Another Contact (Y / N)--->");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    deleteContacts();
                }else if(ch=='N' || ch=='n'){
                   clearConsole();
                   homePage();
                }
            }
           
        }while(true);
    }
    //------------Delete Method---------//
    public static void delete(int index){
        
        String [] deleteTempIdArray=new String[idArray.length-1];
        String [] deleteTempNameArray=new String[idArray.length-1];
        String [] deleteTempPhoneArray=new String[idArray.length-1];
        String [] deleteTempCompanyArray=new String[idArray.length-1];
        double [] deleteTempSalaryArray=new double[idArray.length-1];
        String [] deleteTempBirthDayArray=new String[idArray.length-1];

        for(int i=index;i<idArray.length-1;i++){
            idArray[i]=idArray[i+1];
            nameArray[i]=nameArray[i+1];
           phoneArray[i] =phoneArray[i+1];
            companyArray[i]=companyArray[i+1];
            salatyArray[i]=salatyArray[i+1];
            birthdayArray[i]=birthdayArray[i+1];
        }
        for(int i=0;i<idArray.length-1;i++){
            deleteTempIdArray[i]=idArray[i];
            deleteTempNameArray[i]=nameArray[i];
            deleteTempPhoneArray[i]=phoneArray[i];
            deleteTempCompanyArray[i]=companyArray[i];
            deleteTempSalaryArray[i]=salatyArray[i];
            deleteTempBirthDayArray[i]=birthdayArray[i];
        }

        idArray=deleteTempIdArray;
        nameArray=deleteTempNameArray;
        phoneArray=deleteTempPhoneArray;
        companyArray=deleteTempCompanyArray;
        salatyArray=deleteTempSalaryArray;
        birthdayArray=deleteTempBirthDayArray;
        
    }
    //------------Update Method------------//
    public static void updateContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("===============Update Contacts==========");
            System.out.print("\n Search Contacts by name or phone Number : ");
            String nameOrPhone=input.next();
            int index=searchByNameOrPhone(nameOrPhone);
            if(index==-1){
                System.out.println("\nNo contact Found");
                System.out.print("\nDo you want to try a new serch (y / N) : ");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    homePage();
                }
            }else{
                printDetails(index);

                System.out.println("\n What do you do want to Update?");
                System.out.println("\t[1]Name");
                System.out.println("\t[2]Phone");
                System.out.println("\t[3]Company");
                System.out.println("\t[4]Salary");
                System.out.print("\nEneter An Option ---->");
                int option=input.nextInt();
                switch (option) {
                    case 1:
                        isUpdateName(index);
                        break;
                    case 2:
                        isUpdatePhone(index);
                        break;
                    case 3:
                        isUpdateCompany(index);
                        break;
                    case 4:
                        isUpdateSalary(index);
                        break;
                    default:
                        System.out.println("\nInvalid Option !");
                        break;
                }
                System.out.println("\nContact have been Added Succesfully");
                System.out.print("\nDo you want to Update Another Contact (Y / N)---->");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    updateContacts();
                }else if(ch=='N' || ch=='n' ){
                    clearConsole();
                    homePage();
                }
            }
        }while(true);
    }
    //-----------Update Name Method-------------//
    public static void isUpdateName(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\nUpdate Name");
        System.out.println("=====================");
        System.out.println("\nInput New Name :");
        String newName=input.next();
        nameArray[index]=newName;
    }
    //------------Update Phone Number--------------//
    public static void isUpdatePhone(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\nUpdate Phone Number");
        System.out.println("=====================");
        System.out.println("\nInput New Phone Number :");
        String newPhone=input.next();
        phoneArray[index]=newPhone;
    }
    //------------Update Company name Method-------//
    public static void isUpdateCompany(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\nUpdate Company Name");
        System.out.println("=====================");
        System.out.println("\nInput New Company Name :");
        String newCompany=input.next();
        companyArray[index]=newCompany;
    }
    //-----------Update Salary Method------------//
    public static void isUpdateSalary(int index){
        Scanner input=new Scanner(System.in);
        System.out.println("\nUpdate Salary");
        System.out.println("=====================");
        System.out.println("\nInput New Salary :");
        double newSalary=input.nextDouble();
        salatyArray[index]=newSalary;
    }
    //-----------Search Contacts Method----------//
    public static void searchContacts(){
        Scanner input=new Scanner(System.in);
        do{
            System.out.println("=========================Search Contacts=================");
            System.out.print("\n Search Contacts by name or phone Number : ");
            String nameOrPhone=input.next();
            int index=searchByNameOrPhone(nameOrPhone);
            if(index==-1){
                System.out.println("\nNo contact Found");
                System.out.print("\nDo you want to try a new serch (y / N) : ");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    homePage();
                }
            }else{
                printDetails(index);
                System.out.print("\nDo you want to another Search Contact :");
                char ch=input.next().charAt(0);
                if(ch=='Y' || ch=='y'){
                    clearConsole();
                    searchContacts();
                }else if(ch=='N' || ch=='n'){
                    clearConsole();
                    homePage();
                }
            }
        }while(true);
    }
    //----------Print Details-------------//
    public static void printDetails(int index){
        System.out.println("\nContact ID:"+idArray[index]);
        System.out.println("\nName      :"+nameArray[index]);
        System.out.println("\nPhone Num :"+phoneArray[index]);
        System.out.println("\nCompany Name :"+companyArray[index]);
        System.out.println("\nSalary       :"+salatyArray[index]);
        System.out.println("\nBirth Day    :"+birthdayArray[index]);
    }
    //-------------Search By Name Or Phone------------------//
    public static int searchByNameOrPhone(String nameOrPhone){
        for(int i=0; i<idArray.length;i++){
            if(nameArray[i].equals(nameOrPhone) || phoneArray[i].equals(nameOrPhone)){
                return i;
            }
        }
        return -1;
    }
    //--------Add Contacts-----------//
    public static void addContacts(){
        Scanner input=new Scanner(System.in);
        L4:do{
            System.out.println("================Add Contacts================");
            
            String id=generateId();
            System.out.println("\n"+id);
            System.out.println("=============");
            System.out.print("Name  : ");
            String name=input.next();
            String phoneNum;
            L1:do{
                System.out.print("Phone Number : ");
                 phoneNum=input.next();
                if(!isValidPhoneNumber(phoneNum)){
                    System.out.println("\n\tInavlid Phone Number !");
                    System.out.print("\nDo you want to input phone number Aganin --->(Y / N) :");
                    char ch=input.next().charAt(0);
                    if(ch=='Y' || ch=='y'){
                        System.out.println("\033[5A");
                        System.out.println("\033[0J");
                        continue L1;
                    }if(ch=='N' || ch=='n'){
                        clearConsole();
                        homePage();
                    }
                }
            }while(!isValidPhoneNumber(phoneNum));
            System.out.print("Company name : ");
            String companyName=input.next();
            double salary;
           L2: do{
                System.out.print("Salary : ");
                salary=input.nextDouble();
                if(!isValidSalary(salary)){
                    System.out.println("\n\tInvalid Salary !");
                    System.out.print("\nDo you want to input Salary again (Y / N)---->");
                    char ch=input.next().charAt(0);
                    if(ch=='Y' || ch=='y'){
                        System.out.println("\033[5A");
                        System.out.println("\033[0J");
                        continue L2;
                    }if(ch=='N' || ch=='n'){
                        clearConsole();
                        homePage();
                    }
                }
            }while(!isValidSalary(salary));
            String birthDay;
            L3:do{
                System.out.print("Birthday : ");
                birthDay=input.next();
                if(!isValidBirthDay(birthDay)){
                    System.out.println("\n\tInvalid Birthday !");
                    System.out.print("\nDo you want to input Birthday again (Y / N)--->");
                    char ch=input.next().charAt(0);
                    if(ch=='Y' || ch=='y'){
                        System.out.println("\033[5A");
                        System.out.println("\033[0J");
                        continue L3;
                    }if(ch=='N' || ch=='n'){
                        clearConsole();
                        homePage();
                    }

                }
            }while(!isValidBirthDay(birthDay));
            extendArray();
            idArray[idArray.length-1]=id;
            nameArray[idArray.length-1]=name;
            phoneArray[idArray.length-1]=phoneNum;
            companyArray[idArray.length-1]=companyName;
            salatyArray[idArray.length-1]=salary;
            birthdayArray[idArray.length-1]=birthDay;
            System.out.println("\n\tContacts has been added successfully ..");
            System.out.print("\nDo you add the another Contact Number (Y / N)---->");
            char ch=input.next().charAt(0);
            if(ch=='Y' || ch=='y'){
                clearConsole();
                addContacts();
                continue L4;
            }if(ch=='N' || ch=='n'){
                clearConsole();
                homePage();
            } 
        }while(true);


    }
    //----------Extends Arrays----------//
    public static void extendArray(){
        String[] tempIdArray=new String[idArray.length+1];
        String[] tempNameArray=new String[idArray.length+1];
        String[] tempPhoneArray=new String[idArray.length+1];
        String[] tempComArray=new String[idArray.length+1];
        double[] tempSalArray=new double[idArray.length+1];
        String[] tempBirthDayArray=new String[idArray.length+1];

        for(int i=0;i<idArray.length;i++){
            tempIdArray[i]=idArray[i];
            tempNameArray[i]=nameArray[i];
            tempPhoneArray[i]=phoneArray[i];
            tempComArray[i]=companyArray[i];
            tempSalArray[i]=salatyArray[i];
            tempBirthDayArray[i]=birthdayArray[i];
        }
        idArray=tempIdArray;
        nameArray=tempNameArray;
        phoneArray=tempPhoneArray;
        companyArray=tempComArray;
        salatyArray=tempSalArray;
        birthdayArray=tempBirthDayArray;

    }
    //---------Generate Id-------------//
    public static String generateId(){
        if(idArray.length==0){
            return "C0001";
        }
        String lastId=idArray[idArray.length-1];
        int lastNo=Integer.parseInt(lastId.substring(1));
        return String.format("C%04d", lastNo+1);
    }
    //--------------Validate Phone Number---------//
    public static boolean isValidPhoneNumber(String phoneNum){
        if(phoneNum.length()==10 && phoneNum.charAt(0)=='0'){
            for(int i=1;i<phoneNum.length();i++){
                if(!Character.isDigit(phoneNum.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    //-------------Validate Salary------//
     public static boolean isValidSalary(double salary){
        return salary>0;
     }
     //----------Validate Birth day----------//
     public static boolean isValidBirthDay(String birthday){
        int year=Integer.parseInt(birthday.substring(0,4));
        int month=Integer.parseInt(birthday.substring(5,7));
        int day=Integer.parseInt(birthday.substring(8,10));
        LocalDate currentDate=LocalDate.now();
        int currentYear=currentDate.getYear();
        int currentMonth=currentDate.getMonthValue();
        int currentDay=currentDate.getDayOfMonth();

       
        if(year%4!=0 && month==2){
            if(day>28){
                return false;
            }
            return true;
        }
        if(year%4==0 && year%100!=0 && month==2){
            if(day>29){
                return false;
            }
            return true;
        }

        if(month==4 || month==6 || month==9 || month==11){
            if(day>30){
                return false;
            }
            if(month>12){
                return false;
            }
            if(year<currentYear){
                return true;
            }else if(year==currentYear){
                if(month<currentMonth){
                    return true;
                }else if(month==currentMonth){
                    if(day<=currentDay){
                        return true;
                    }
                }
            }
         }
         if(month==1 || month==3|| month==5 || month==7 || month==10 || month==12){
            if(day>31){
                return false;
            }
            if(month>12){
                return false;
            }
            if(year<currentYear){
                return true;
            }else if(year==currentYear){
                if(month<currentMonth){
                    return true;
                }else if(month==currentMonth){
                    if(day<=currentDay){
                        return true;
                    }
                }
            }
        }
        return false;
     }
    //--------Main method-------------//
    public static void main(String []args){
       homePage();
    }
}






	

   


