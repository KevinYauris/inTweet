package istweet;
import twitter4j.*;
import java.util.List;
import twitter4j.conf.ConfigurationBuilder;
/**
 *
 * @author KEVIN
 */
public class IsTweet {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    ConfigurationBuilder cb = new ConfigurationBuilder(); 
    cb.setDebugEnabled(true)
            .setOAuthConsumerKey("2BDxsUOwujr6MwNArdW6T6l42")
            .setOAuthConsumerSecret("RqgxWAZGFhcERbJcbp37p3Xa9nHh78qidTiW6cftqX46Taw1p3")
            .setOAuthAccessToken("259316897-UKzBGelRixIeZYDtjHSDLoMjbib0Z57UOO4Sn9G5")
            .setOAuthAccessTokenSecret("tPttYyNAVgjrSWAipw5FjdD9OntisyJrpJ79FeQHWv6bz");
            // TODO code application logic here
    
    TwitterFactory tf = new TwitterFactory(cb.build());
    Twitter twitter = tf.getInstance();
 

 try {
        Query query = new Query("ambis");
        QueryResult result;
        
       do {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();
            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText() + tweet.getSource());
            
            }
         } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        
        }
        }
    }
    
