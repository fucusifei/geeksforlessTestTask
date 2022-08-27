package com.geeksforless.yevdokymov;

import com.geeksforless.yevdokymov.db.*;
import com.geeksforless.yevdokymov.javaCore.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int input = 0;
        Creator creator = new Creator();
        creator.createNewTable();
        ConnectionToDb connectionToDb = new ConnectionToDb();

        System.out.println("Вас вітає калькулятор арифметичних виразів. Введіть будь ласка той, який бажаєте вирішити");
        calculate(connectionToDb);
        while (input != 6) {
            System.out.println("Оберіть наступну функцію зі списку для продовження на введіть її номер");
            System.out.println("1) Перегляд таблиці з БД");
            System.out.println("2) Пошук виразів в БД");
            System.out.println("3) Редагування виразу з БД");
            System.out.println("4) Вирішення нового виразу");
            System.out.println("5) Видалення всіх значень з БД");
            System.out.println("6) Для завершення роботи натисніть будь-яку клавішу");
            Scanner in = new Scanner(System.in);
            input = in.nextInt();
            switch (input) {
                case 1 -> {
                    Viewer viewer = new Viewer();
                    viewer.view(connectionToDb.getConnectionToDb());
                }
                case 2 -> {
                    System.out.println("Для пошуку необхідного виразу введіть пошукове слово (> , < , = , >=, <=) та необхідний результат арифметичного виразу");
                    Scanner in2 = new Scanner(System.in);
                    Scanner in3 = new Scanner(System.in);
                    String searchWord = in3.nextLine();
                    int result = in2.nextInt();
                    DBSearch dbSearch = new DBSearch();
                    dbSearch.search(connectionToDb.getConnectionToDb(), searchWord, result);
                }
                case 3 -> {
                    Viewer viewer = new Viewer();
                    viewer.view(connectionToDb.getConnectionToDb());
                    System.out.println("Введіть будь ласка вираз, який бажаєте замінити");
                    Scanner in4 = new Scanner(System.in);
                    String arithmeticExpressionToChange = in4.nextLine();
                    System.out.println("Введіть будь ласка вираз, на який бажаєте замінити");
                    Scanner in5 = new Scanner(System.in);
                    StringBuilder arithmeticExpression = new StringBuilder(in5.nextLine());

                    DBUpdater dbUpdater = new DBUpdater();
                    dbUpdater.update(connectionToDb.getConnectionToDb(), arithmeticExpression.toString(), arithmeticExpressionToChange, calculateToUpdate(arithmeticExpression));
                }
                case 4 -> {
                    calculate(connectionToDb);
                }
                case 5 -> {
                    DBUpdater dbUpdater = new DBUpdater();
                    dbUpdater.delete(connectionToDb.getConnectionToDb());
                }
                default -> {
                    System.out.println("До побачення");
                    input = 6;
                }
            }
        }
    }
    public static void calculate(ConnectionToDb connectionToDb) throws Exception {
        Input inputObj = new Input();
        inputObj.input();

        ArithmeticExpressionValuesAnalyze analyze = new ArithmeticExpressionValuesAnalyze();
        analyze.analyze(inputObj.arithmeticExpression);

        ParenthesisChecker parenthesisChecker = new ParenthesisChecker();
        parenthesisChecker.ParenthesisCheckerAnalyze(analyze.values);
        OperatorsChecker operatorsChecker = new OperatorsChecker();
        operatorsChecker.OperatorsCheckerAnalyze(analyze.values);

        ArithmeticExpressionCalculating arithmeticExpressionCalculating = new ArithmeticExpressionCalculating();
        DBUpdater dbUpdater = new DBUpdater();
        dbUpdater.add(connectionToDb.getConnectionToDb(), inputObj.arithmeticExpression.toString(),arithmeticExpressionCalculating.calculate(analyze.values));
    }
    public static Double calculateToUpdate(StringBuilder arithmeticExpression) throws Exception {


        ArithmeticExpressionValuesAnalyze analyze = new ArithmeticExpressionValuesAnalyze();
        analyze.analyze(arithmeticExpression);

        ParenthesisChecker parenthesisChecker = new ParenthesisChecker();
        parenthesisChecker.ParenthesisCheckerAnalyze(analyze.values);
        OperatorsChecker operatorsChecker = new OperatorsChecker();
        operatorsChecker.OperatorsCheckerAnalyze(analyze.values);

        ArithmeticExpressionCalculating arithmeticExpressionCalculating = new ArithmeticExpressionCalculating();
        return arithmeticExpressionCalculating.calculate(analyze.values);
    }
}
