package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Main {

    static Document d;
    static Elements e;

    public static void main(String[] args) throws Exception {
        final int N = 20000;
        final int M = 1000000;

        String s;

        int count_0 = 0, count_1 = 0;
        int count_00 = 0, count_01 = 0, count_10 = 0, count_11 = 0;
        int count_000 = 0, count_001 = 0, count_010 = 0, count_011 = 0,
                count_100 = 0, count_101 = 0, count_110 = 0, count_111 = 0;

        int percent_0, percent_1, percent_00, percent_01, percent_10,percent_11;
        int percent_000, percent_001, percent_010, percent_011,
                percent_100, percent_101, percent_110, percent_111;

        char[] chars = new char[M];

        for(int k = 0, j = 0; k < 100; ++k){
            d = Jsoup.connect("https://www.random.org/integers/?num=10000&min=0&max=1&col=1&base=10&format=html&rnd=new").get();
            e = d.getElementsByClass("data");

            s = e.text();
            for (int i = 0; i < N - 1; ++i){
                if(s.charAt(i) == '1' | s.charAt(i) == '0'){
                    chars[j] = s.charAt(i);
                    ++j;
                }
            }
        }

        for(int i = 0; i < M; ++i){
            if(chars[i] == '0'){
                ++count_0;
                if(i < (M) - 1 && chars[i + 1] == '0'){
                    ++count_00;
                    if(i < (M) - 2 && chars[i + 2] == '0'){
                        ++count_000;
                    }
                    else{
                        if( i < (M) - 2){
                            ++count_001;
                        }
                    }
                }
                else{
                    if(i < (M) - 1){
                        ++count_01;
                        if(i < (M) - 2 && chars[i + 2] == '0'){
                            ++count_010;
                        }
                        else{
                            if( i < (M) - 2){
                                ++count_011;
                            }
                        }
                    }

                }
            }
            else{
                ++count_1;
                if(i < (M) - 1 && chars[i + 1] == '0'){
                    ++count_10;
                    if(i < (M) - 2 && chars[i + 2] == '0'){
                        ++count_100;
                    }
                    else{
                        if(i < (M) - 2){
                            ++count_101;
                        }
                    }
                }
                else{
                    if(i < (M) - 1){
                        ++count_11;
                        if(i < (M) - 2 && chars[i + 2] == '0'){
                            ++count_110;
                        }
                        else{
                            if(i < (M) - 2){
                                ++count_111;
                            }
                        }
                    }
                }
            }
        }


        percent_0 = (100 * count_0) / M;
        percent_1 = (100 * count_1) / M;
        percent_00 = (100 * count_00) / M;
        percent_01 = (100 * count_01) / M;
        percent_10 = (100 * count_10) / M;
        percent_11 = (100 * count_11) / M;
        percent_000 = (100 * count_000) / M;
        percent_001 = (100 * count_001) / M;
        percent_010 = (100 * count_010) / M;
        percent_011 = (100 * count_011) / M;
        percent_100 = (100 * count_100) / M;
        percent_101 = (100 * count_101) / M;
        percent_110 = (100 * count_110) / M;
        percent_111 = (100 * count_111) / M;

        System.out.println("amount of 0 = " + count_0 + ", % of 0 = " + percent_0);
        System.out.println("amount of 1 = " + count_1 + ", % of 1 = " + percent_1);
        System.out.println();
        System.out.println("amount of 00 = " + count_00 + ", % of 00 = " + percent_00);
        System.out.println("amount of 01 = " + count_01 + ", % of 01 = " + percent_01);
        System.out.println("amount of 10 = " + count_10 + ", % of 10 = " + percent_10);
        System.out.println("amount of 11 = " + count_11 + ", % of 11 = " + percent_11);
        System.out.println();
        System.out.println("amount of 000 = " + count_000 + ", % of 000 = " + percent_000);
        System.out.println("amount of 001 = " + count_001 + ", % of 001 = " + percent_001);
        System.out.println("amount of 010 = " + count_010 + ", % of 010 = " + percent_010);
        System.out.println("amount of 011 = " + count_011 + ", % of 011 = " + percent_011);
        System.out.println("amount of 100 = " + count_100 + ", % of 100 = " + percent_100);
        System.out.println("amount of 101 = " + count_101 + ", % of 101 = " + percent_101);
        System.out.println("amount of 110 = " + count_110 + ", % of 110 = " + percent_110);
        System.out.println("amount of 111 = " + count_111 + ", % of 111 = " + percent_111);
    }
}