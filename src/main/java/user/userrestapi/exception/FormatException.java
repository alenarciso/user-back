package user.userrestapi.exception;

public class FormatException {

    public static String formatUniqueException(String message){
        String detail = null;
        if(message.contains("duplicate key value violates unique constraint")){
            detail = "O campo "+fieldUnique(message)+" já existe!";
        }
        return detail != null ? detail : message;
    }
    private static String fieldUnique(String message){
        //campos com unicidades do banco de dados
        if(message.contains("user_name")){
            return "Usuário";
        }else  if(message.contains("email")){
            return "Email";
        }else  if(message.contains("cpf")){
            return "CPF";
        }
        return null;
    }
}
