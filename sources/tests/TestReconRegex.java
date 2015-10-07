package tests;

import utils.ReconRegex;

import java.io.File;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class TestReconRegex{

    private String[] contents;

    @Before
    public void init(){
        contents = new File("/Users/doudou/myWorld/dossiers/ludique/scans/DC Week+ (07-08-2015)").list();
    }

    @Test
    public void testRegex(){
        for( int i = 0; i< contents.length; i++ ){
            String regex = ReconRegex.recon(contents[i]);
            assertTrue( contents[i].matches(regex) );
        }
    }


}

