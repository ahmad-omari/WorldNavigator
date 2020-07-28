package GameObjects;

public class GameSRP {
    private String player1;
    private String player2;

    public GameSRP(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getWinner(){
        String p1 = getRandomChoice();
        String p2 = getRandomChoice();
        while (p1.equals(p2)){
            p1 = getRandomChoice();
            p2 = getRandomChoice();
        }
        String winner = getWinner(p1,p2);
        if (winner.equals(p1))
            return player1;
        return player2;
    }

    private String getRandomChoice(){
        int randomNumber = (int) (Math.random() * (3) + 1);
        switch (randomNumber){
            case 1:
                return "rock";
            case 2:
                return "paper";
            case 3:
                return "scissors";
        }
        return "rock";
    }

    private String getWinner(String p1,String p2){
        if (p1.equals("rock")) {
            if (p2.equals("scissors"))
                return p1;
            else if (p2.equals("paper"))
                return p2;
        }
        else if (p1.equals("paper")) {
            if (p2.equals("scissors"))
                return p2;
            else if (p2.equals("rock"))
                return p1;
        }
        else if (p1.equals("scissors")) {
            if (p2.equals("paper"))
                return p1;
            else if (p2.equals("rock"))
               return p2;
        }
        return p1;
    }
}
