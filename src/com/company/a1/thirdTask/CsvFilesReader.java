package com.company.a1.thirdTask;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class CsvFilesReader {

    private static final String FIELD_NAME = "авторизованная поставка";
    private static final String HEADER_OF_TABLE = "Mat. Doc.,\tItem,\tDoc..Date,\tPstng Date,\tMaterial Description,\tQuantity,\tBUn,\tAmount LC,\tCrcy,\tUser Name";
    private static final int NUMBER_OF_APP_ACCOUNT_NAME_COLUMN = 1;
    private static final int NUMBER_OF_IS_ACTIVE_COLUMN = 2;
    private static final int NUMBER_OF_USER_NAME_COLUMN = 9;


    public static void readAllFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String tmp;
            while ((tmp = br.readLine()) != null) {
                System.out.println(tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readColumnFromTable(String filePath, int columnNumber) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String tmp;
            while ((tmp = br.readLine()) != null) {
                String[] s = tmp.split(",");
                System.out.println(s[columnNumber]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void leftJoinTwoFiles(String leftFilePath, String rightFilePath) {
        HashSet<String> activeUsers = new HashSet<>();
        try (BufferedReader rightBr = new BufferedReader(new FileReader(rightFilePath))) {
            String tmp;
            while ((tmp = rightBr.readLine()) != null) {
                String[] s = tmp.split(",");
                if (s[NUMBER_OF_IS_ACTIVE_COLUMN].equals("\tTrue")) {
                    activeUsers.add(s[NUMBER_OF_APP_ACCOUNT_NAME_COLUMN]);
                }
            }
            for (String activeUser : activeUsers) {
                System.out.println(activeUser);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader leftBr = new BufferedReader(new FileReader(leftFilePath))) {
            String tmp;
            while ((tmp = leftBr.readLine()) != null) {

                if (tmp.equals(HEADER_OF_TABLE)) {
                    System.out.print(tmp);
                    System.out.println(",   " + FIELD_NAME);
                    continue;
                }
                String[] columns = tmp.split(",");


                if (activeUsers.contains(columns[NUMBER_OF_USER_NAME_COLUMN])) {
                    System.out.print(tmp);
                    System.out.println(",   TRUE");
                } else {
                    System.out.print(tmp);
                    System.out.println(",   FALSE");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
