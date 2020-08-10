package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    Job testJob1;
    Job testJob2;

    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
    }

    @Test
    public void testSettingJobID(){
        assertEquals(1,testJob2.getId()-testJob1.getId(), .001  );
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob.getName()=="Product tester");
        assertTrue(testJob instanceof Job);

        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getEmployer().getValue()=="ACME");

        assertTrue(testJob.getLocation().getValue()=="Desert");
        assertTrue(testJob.getLocation() instanceof Location);

        assertTrue((testJob.getPositionType() instanceof PositionType));
        assertTrue(testJob.getPositionType().getValue()=="Quality control");

        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob.getCoreCompetency().getValue()=="Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job controlJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob =new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(controlJob.equals(testJob));
    }

}
