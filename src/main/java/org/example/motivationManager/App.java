package org.example.motivationManager;

import org.example.controller.MotivationCotroller;
import org.example.controller.SystemController;

public class App {

    public void run () {

        MotivationCotroller motivationController = new MotivationCotroller();
        SystemController systemController = new SystemController();

        motivationController.makeTestData();

        while (true) {
            System.out.print("명령어) ");
            String cmd = Container.getScanner().nextLine().trim();

            if (cmd.isEmpty()) {
                System.out.println("명령어를 입력하세요.");
                continue;
            }

            if (cmd.equals("exit")) {
                systemController.exit();
                break;
            } else if (cmd.equals("motivation write")) {
                motivationController.doWrite();
            } else if (cmd.startsWith("motivation list")) {
                motivationController.showList(cmd);
            } else if (cmd.startsWith("motivation detail")) {
                motivationController.showDetail(cmd);
            } else if (cmd.startsWith("motivation delete")) {
                motivationController.doDelete(cmd);
            } else if (cmd.startsWith("motivation modify")) {
                motivationController.doModify(cmd);
            } else System.out.println("잘못된 명령어입니다.");
        }
    }
}
