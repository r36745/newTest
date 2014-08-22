package rosemak.weekthreev2;

/**
 * Created by stevierose on 8/17/14.
 */
public class FantasyTeam {

    private String playerName;
    private String playerPosition;
    private String playerTeam;
    private int playerRating;

    public FantasyTeam (String _playerName, String _playerTeam, String _playerPosition, int _playerRating) {

        playerName     = _playerName;
        playerTeam     = _playerTeam;
        playerPosition = _playerPosition;
        playerRating   = _playerRating;
    }

    //Setter Methods
    public void setPlayerName(String _playerName) {this.playerName = _playerName;}
    public void setPlayerTeam(String _playerTeam) {this.playerTeam = _playerTeam;}
    public void setPlayerPosition(String _playerPosition) {this.playerPosition = _playerPosition;}
    public void setPlayerRating(int _playerRating) {this.playerRating = _playerRating;}

    //Getter Methods


    public String getPlayerName() {
        return this.playerName;
    }

    public String getPlayerTeam() {
        return this.playerTeam;
    }

    public String getPlayerPosition() {
        return this.playerPosition;
    }

    public int getPlayerRating() {
        return this.playerRating;
    }
}
