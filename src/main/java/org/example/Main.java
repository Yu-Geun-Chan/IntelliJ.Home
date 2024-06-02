package org.example;


public class Main {
    public static void main(String[] args) {

        int age = 10;

// v1
        if (age < 10) {
            System.out.println("아동/영유아");
        }
        if (age >= 10 && age < 20) {
            System.out.println("10대");
        }
        if (age >= 20) {
            System.out.println("20대 이상");
        }

// v2
        if (age < 10) {
            System.out.println("아동/영유아");
        } else if (age >= 10 && age < 20) {
            System.out.println("10대");
        } else if (age >= 20) {
            System.out.println("20대 이상");
        }

// v2-2
        if (age < 10) {
            System.out.println("아동/영유아");
        } else if (age < 20) {
            System.out.println("10대");
        } // 여기서는 `나이가 10살 보다 크다`라는 조건을 빼도 된다. 왜냐하면 10살 보다 작았다면 애초에 이 부분이 실행되지 않는다. 바로 윗줄조건(age < 10)이 참으로 나와서에서 윗줄만 실행됨(else 로 fi문 들을 묶은 덕분)
        else if (age >= 20) {
            System.out.println("20대 이상");
        }

// v3
        if (age < 10) {
            System.out.println("아동/영유아");
        } else if (age < 20) {
            System.out.println("10대");
        } else {
            System.out.println("20대 이상");
        } // 전체(3가지) 경우의 수 중에서 무조건 정답이 1개 존재한다면, 마지막 if문의 조건식은 지우는게 좋다.
    }
}