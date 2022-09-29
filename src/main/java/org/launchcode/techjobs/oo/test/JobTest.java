package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job3 = new Job("Product Tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job3.getName(), "Product Tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        Job job4 = new Job("Bottle Capper", new Employer("Duff"), new Location("Springfield"), new PositionType("Quality Control"), new CoreCompetency("Attentive"));
        Job job5 = new Job("Bottle Capper", new Employer("Duff"), new Location("Springfield"), new PositionType("Quality Control"), new CoreCompetency("Attentive"));

        assertFalse(job4.getId() == job5.getId());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job4 = new Job("Bottle Capper", new Employer("Duff"), new Location("Springfield"), new PositionType("Quality Control"), new CoreCompetency("Attentive"));
        String output = "\nID: " + job4.getId() +
                        "\nName: " + job4.getName() +
                        "\nEmployer: " + job4.getEmployer() +
                        "\nLocation: " + job4.getLocation() +
                        "\nPosition Type: " + job4.getPositionType() +
                        "\nCore Competency: " + job4.getCoreCompetency() +
                        "\n";

        String firstLine = job4.toString().substring(0,1);
        String lastLine = job4.toString().substring(job4.toString().length()-1,job4.toString().length());

        assertEquals(firstLine, "\n");
        assertEquals(lastLine, "\n");
        assertEquals(firstLine,lastLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job job4 = new Job("Bottle Capper", new Employer("Duff"), new Location("Springfield"), new PositionType("Quality Control"), new CoreCompetency("Attentive"));
        String output = "\nID: " + job4.getId() +
                "\nName: " + job4.getName() +
                "\nEmployer: " + job4.getEmployer() +
                "\nLocation: " + job4.getLocation() +
                "\nPosition Type: " + job4.getPositionType() +
                "\nCore Competency: " + job4.getCoreCompetency() +
                "\n";

        assertEquals(output, job4.toString());
    }


    @Test
    public void testToStringHandlesEmptyField(){
        Job job4 = new Job("", new Employer(""), new Location("Springfield"), new PositionType("Quality Control"), new CoreCompetency("Attentive"));
        String output = "\nID: " + job4.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: " + job4.getLocation() +
                "\nPosition Type: " + job4.getPositionType() +
                "\nCore Competency: " + job4.getCoreCompetency() +
                "\n";

        assertEquals(output, job4.toString());
    }

    @Test
    public void testToStringHandlesEmptyString(){
        Job job6 = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));

        String output = "OOPS! This job does not seem to exist.";

        assertEquals(output, job6.toString());
    }

}
