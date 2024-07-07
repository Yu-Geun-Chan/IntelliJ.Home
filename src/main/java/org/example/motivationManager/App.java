package org.example.motivationManager;

import org.example.controller.MotivationCotroller;
import org.example.controller.SystemController;

public class App {

    public void run () {

        MotivationCotroller motivationController = new MotivationCotroller();
        SystemController systemController = new SystemController();

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
            } else if (cmd.equals("write")) {
                motivationController.doWrite();
            } else if (cmd.startsWith("list")) {
                motivationController.showList(cmd);
            } else if (cmd.startsWith("detail")) {
                motivationController.showDetail(cmd);
            } else if (cmd.startsWith("delete")) {
                motivationController.doDelete(cmd);
            } else if (cmd.startsWith("modify")) {
                motivationController.doModify(cmd);
            }
        }
    }
}
