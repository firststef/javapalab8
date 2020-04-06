package lab8;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main (String[] args){

        Database.setInstance("jdbc:mysql://localhost:3306/musicalbums", "dba", "sql");
        try (Database db = Database.getInstance()){
            ArtistController.create("Red", "USA");
            Artist artist = ArtistController.findByName("Red");
            AlbumController.create("End of Silence", artist.getId(), 2006);
            Album album = AlbumController.findByArtist(artist.getId());
            if (!album.getName().equals("End of Silence")){
                throw new SQLException();
            }
        }
        catch (SQLException | IOException ex){
            System.out.println("Test has failed");
            return;
        }
        System.out.println("Test has passed");
    }
}
