package org.example.controller;

import org.example.motivationManager.Container;
import org.example.dto.Motivation;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;

public class MotivationCotroller {
    int lastMotivationId;
    List<Motivation> motivations;

    public MotivationCotroller() {
        lastMotivationId = 3;
        this.motivations = new ArrayList<>();
    }


    public void doWrite() {
        System.out.println("== Motivation write ==");
        System.out.print("내용 : ");
        String body = Container.getScanner().nextLine();
        System.out.print("출처 : ");
        String source = Container.getScanner().nextLine();
        String regDate = Util.getNow();
        String updateDate = regDate;
        int id = lastMotivationId + 1;

        Motivation motivation = new Motivation(id, regDate, regDate, body, source);

        motivations.add(motivation);
        lastMotivationId++;

        System.out.printf("%d번 Motivation이 생성되었습니다.\n", id);
    }

    public void showList(String cmd) {
        System.out.println("== Motivation list ==");

        if (motivations.isEmpty()) {
            System.out.println("작성된 게시글이 없습니다.");
            return;
        }

        String searchWord = cmd.substring("motivation list".length()).trim();

        List<Motivation> forPrintMotivations = motivations;

        if (!searchWord.isEmpty()) {
            System.out.printf("검색어 : %s\n", searchWord);
            forPrintMotivations = new ArrayList<>();
            return;
        }

        for (Motivation motivation : motivations) {
            if (motivation.getBody().contains(searchWord)) {
               forPrintMotivations.add(motivation);
            }
        }

        if (forPrintMotivations.isEmpty()) {
            System.out.println("작성된 Motivation이 없습니다.");
            return;
        }

        for (int i = forPrintMotivations.size() - 1; i >= 0; i--) {
            Motivation motivation = forPrintMotivations.get(i);
            System.out.println("   번호   /     작성일    /     내용    /     출처    /");
            System.out.println("=".repeat(50));
            if (motivation.getRegDate().split(" ")[0].equals(motivation.getRegDate().split(" ")[0])) {
                System.out.printf("  %d   /    %s     /    %s     /     %s    \n", motivation.getId(), motivation.getRegDate().split(" ")[1], motivation.getBody(), motivation.getSource());
            } else
                System.out.printf("  %d   /    %s     /    %s     /     %s    \n", motivation.getId(), motivation.getRegDate().split(" ")[0], motivation.getBody(), motivation.getSource());
        }
    }

    public void showDetail(String cmd) {
        System.out.println("== Motivation detail ==");

        String[] cmdBits = cmd.split(" ");

        int id;
        try {
            id = Integer.parseInt(cmdBits[2]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
                break;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 Motivation은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("번호 : %d\n", foundMotivation.getId());
        System.out.printf("작성일 : %s\n", foundMotivation.getRegDate());
        System.out.printf("수정일 : %s\n", foundMotivation.getUpdateDate());
        System.out.printf("내용 : %s\n", foundMotivation.getBody());
        System.out.printf("출처 : %s\n", foundMotivation.getSource());
    }

    public void doDelete(String cmd) {
        System.out.println("== Motivation delete ==");

        String[] cmdBits = cmd.split(" ");

        int id;
        try {
            id = Integer.parseInt(cmdBits[2]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 Motivation은 존재하지 않습니다.\n", id);
            return;
        }

        motivations.remove(foundMotivation);
        System.out.printf("%d번 Motivation은 삭제되었습니다.\n", foundMotivation.getId());
    }

    public void doModify(String cmd) {
        System.out.println("== Motivation modify ==");

        String[] cmdBits = cmd.split(" ");

        int id;
        try {
            id = Integer.parseInt(cmdBits[2]);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력하세요.");
            return;
        }

        Motivation foundMotivation = null;
        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
            }
        }

        if (foundMotivation == null) {
            System.out.printf("%d번 Motivation은 존재하지 않습니다.\n", id);
            return;
        }

        System.out.printf("기존 내용 : %s\n", foundMotivation.getBody());
        System.out.printf("기존 출처 : %s\n", foundMotivation.getSource());
        System.out.print("내용 : ");
        String newBody = Container.getScanner().nextLine();
        System.out.print("출처 : ");
        String newSource = Container.getScanner().nextLine();

        foundMotivation.setBody(newBody);
        foundMotivation.setBody(newSource);
        foundMotivation.setBody(Util.getNow());


        System.out.printf("%d번 Motivation은 수정되었습니다.\n", foundMotivation.getId());
    }
}
