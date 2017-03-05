package com.medicine.neo4j.disease;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Result;
import org.neo4j.graphdb.Transaction;
import org.neo4j.ogm.testutil.TestServer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(classes = {com.medicine.neo4j.MyConfiguration.class,com.medicine.neo4j.service.impl.DiseaseServiceImpl.class
        ,com.medicine.neo4j.dao.DiseaseRepository.class})
public class TmpleteTest {

    private static TestServer testServer;

    @BeforeClass
    public static void setupTestServer() {
        testServer = new TestServer.Builder().build();
    }

    @AfterClass
    public static void teardownTestServer() {
        testServer.shutdown();
    }

    @Test
    public void shouldCreateUser() {

        GraphDatabaseService db = testServer.getGraphDatabaseService();

        try (Transaction tx = db.beginTx()) {
            Result r = db.execute("MATCH (u:User {name: 'Bilbo Baggins'}) RETURN u");

            tx.success();
        }
    }
}
