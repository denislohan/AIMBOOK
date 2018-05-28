package app;

import java.util.Scanner;

import database.LocalFile;
import model.Distributor;
import model.Network;
import model.Node;

public class AIMDesktopBook {

	public static void main(String[] args) {
		//Thread register = new Thread((Runnable) new LocalFile());
//         register.start();		
//		Distributor distributor = new Distributor();
//        Scanner input = new Scanner(System.in);
//        System.out.println("enter the code");
//        distributor.setCode(input.nextLine());
//        System.out.println("enter the first name");
//        distributor.setFirstName(input.nextLine());
//        System.out.println("enter the second name");
//        distributor.setSurname(input.nextLine());
//        System.out.println("enter the tel wth country code");
//        distributor.setPhoneNumber(input.nextLine());
//        System.out.println("enter the upline code");
//        distributor.setUpLineCode(input.nextLine());
//        System.out.println("choose upline side\n 1. Left\n2.Right 3.No upline");
//        int in = input.nextInt();
//        String side;
//        if(in ==1)
//        		side = "left";
//        else if(in == 2)
//        		side = "right";
//        else
//        		side = "";
//        		
//        distributor.setUpLineSide(side);
//
//
//        System.out.println("enter the name of your database");
//        input = new Scanner(System.in);
//        String db = input.nextLine();
//        distributor.setDbName(db);
//        distributor.register(db);
//       
//        input.close();
//        //LocalFile.checkInternetAndSend();

        
        /**
         * 
         * Testing the tree
         * */
        
        Network network = new Network();
        Node node =network.getNetwork("UGDenis", "UG166387db");
        System.out.println(node);

	}

}
