package Task3_dz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String passvord = "sdfsdsdfdsfsdfF5";
        passwordVerification(passvord);
    }

    static void passwordVerification(String password){
        System.out.println(" * Требования:\n" + " * 1. Пароль должен быть не менее 8ми символов.\n" + " * 2. В пароле должно быть число\n" +   " * 3. В пароле должна быть хотя бы 1 строчная буква\n" +
                " * 4. В пароле должна быть хотя бы 1 заглавная буква\n" + " * 5. Не должно быть пробелов\n");
        //Если проверять все полностью
        if (!Pattern.compile("^\\S*$").matcher(password).matches()) {System.out.println("Статус проверки отсутствия пробела: No");} else {System.out.println("Статус проверки отсутствия пробела: OK");
            if (!Pattern.compile("^[a-zA-Z0-9]{8,}$").matcher(password).matches()) {System.out.println("Статус проверки длины пароля: No");} else { System.out.println("Статус проверки длины пароля: OK");
                if (!Pattern.compile("(?=.*[a-z])").matcher(password).find()) {System.out.println("Статус проверки наличие строчных букв: No");} else { System.out.println("Статус проверки наличие строчных букв: OK");
                    if (!Pattern.compile("(?=.*[A-Z])").matcher(password).find()) {System.out.println("Статус проверки наличие заглавных букв: No");} else { System.out.println("Статус проверки наличие заглавных букв: OK");
                        if (!Pattern.compile("(?=.*[0-9])").matcher(password).find()) {System.out.println("Статус проверки наличие числа: No");} else {System.out.println("Статус проверки наличие числа: OK");
                            System.out.println("Пароль валидный, длина пароля " + password.length() + " Ваш пароль: " + password);
                        }
                    }
                }
            }
        }

        //Простой вариант
        Matcher passwordV = Pattern.compile ("^(?=.*[a-z])(?=.*[A-Z])[a-zA-Z0-9]{8,}$").matcher (password);
        System.out.println (passwordV.matches());


}}
