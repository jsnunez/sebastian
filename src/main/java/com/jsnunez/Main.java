package com.jsnunez;

import application.*;
import domain.service.UserService;
import infrastructure.in.UserController;
import infrastructure.out.UserRepository;

public class Main {
    public static void main(String[] args) {


        UserService userService = new UserRepository();

        CreatePersonUseCase createUserUseCase = new CreatePersonUseCase(userService);
        CreateHabilidadUseCase createHabilidadUseCase = new CreateHabilidadUseCase(userService);
       
       UserController adaptador = new UserController(createUserUseCase, createHabilidadUseCase);
       
       
       
       adaptador.start();
       
       
    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
// //         // FindUserUseCase findUserUseCase = new FindUserUseCase(userService);
// //         // UpdateCaseUseUSer updateCaseUseUSer = new UpdateCaseUseUSer(userService);
// //         // DeleteUserUseCase deleteUserUseCase = new DeleteUserUseCase(userService);

// //         // UserController consoleAdapter = new UserController(createUserUseCase,findUserUseCase,deleteUserUseCase,updateCaseUseUSer);
        
// //         int x=0;
// //         while (x!=4) {
            
       
// //         Object[] options = { "Crear usuario", "Buscar ususario", "Editar usuario", "Eliminar usuario"," Salir" };
// //         Object color = JOptionPane.showInputDialog(null, "Seleccione Una Opcion", 
// //                 "MYSQL", JOptionPane.QUESTION_MESSAGE, null, options, "Crear usuario");
        
// //         int selectedIndex = -1; // default value for no selection or "Seleccione"
// //         for (int i = 0; i < options.length; i++) {
// //             if (options[i].equals(color)) {
// //                 selectedIndex = i;
// //                 break;
// //             }
// //         }
// //         if (selectedIndex == 0) {

// //             // consoleAdapter.start();
// //         }
// //         if (selectedIndex == 1) {
         

// //             // consoleAdapter.buscar();
// //         }
// //         if (selectedIndex == 2) {
         
// //           //  UserController consoleAdapter = new UserController(updateCaseUseUSer);
// // //  consoleAdapter.modificar();
// //                 }

// //         if (selectedIndex == 3) {
         
           
// //             //UserController consoleAdapter = new UserController(deleteUserUseCase);

// //             // consoleAdapter.eliminar();
// //         }
        
// //         if (selectedIndex == 4) {
         
           
// //             //UserController consoleAdapter = new UserController(deleteUserUseCase);

// //             System.exit(0);
// //         }

// //     } }
}