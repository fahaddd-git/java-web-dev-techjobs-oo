package org.launchcode.techjobs_oo.Tests;
import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;


public class JobTest {

    Job testJob1;
    Job testJob2;
    Job controlJob;
    Job testJob;
    Job testJobEmptyEmployerField;


    @Before
    public void createJobObjects(){
        testJob1 = new Job();
        testJob2 = new Job();
        controlJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobEmptyEmployerField = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));



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
        assertFalse(controlJob.equals(testJob));
    }

    @Test
    public void testToStringFor(){
    String jobString = testJob.toString();
    String jobOutput = String.format("\nID: %d\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n", testJob.getId(), testJob.getName(), testJob.getEmployer().getValue(), testJob.getLocation().getValue(), testJob.getPositionType().getValue(), testJob.getCoreCompetency().getValue());
    String jobOutputEmptyField = String.format("\nID: %d\nName: %s\nEmployer: Data not available\nLocation: %s\nPosition Type: %s\nCore Competency: %s\n", testJobEmptyEmployerField.getId(), testJobEmptyEmployerField.getName(), testJobEmptyEmployerField.getLocation().getValue(), testJobEmptyEmployerField.getPositionType().getValue(), testJobEmptyEmployerField.getCoreCompetency().getValue());

    assertEquals(0,jobString.indexOf("\n"),.001);
    assertEquals(jobString.length()-1,jobString.lastIndexOf("\n"),.001);
    assertEquals(1, jobString.indexOf("ID"), .001);
    assertEquals(jobString, jobOutput);
    assertEquals(testJobEmptyEmployerField.toString(), jobOutputEmptyField);


    }

}
