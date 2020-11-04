package seedu.duke.commands.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import seedu.duke.DukeExceptions;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjectDescriptionCommandTest {
    static ArrayList<Project> projects;
    static ArrayList<TeamMember> teamMembers;
    static Ui ui = new Ui();
    static HashMap<String, String> params;

    @BeforeAll
    static void createProjectList() {
        projects = new ArrayList<>();
        Project projectOne = new Project("Project One");
        Project projectTwo = new Project("Project Two");
        Project projectThree = new Project("Project Three");
        projects.add(projectOne);
        projects.add(projectTwo);
        projects.add(projectThree);
        projectTwo.addDescription("Do CS2113 Tutorial by today");
        params = new HashMap<>();
    }

    @Test
    void executeCommand_projectList_projectDescriptionAdded() throws DukeExceptions {
        params.put("d", "Do CS2113 Tutorial by today");
        ProjectDescriptionCommand addDescription = new ProjectDescriptionCommand(params, 1);
        String actualOutput = addDescription.executeCommand(projects, teamMembers);
        String expectedOutput = "Project description added \"Do CS2113 Tutorial by today\".";
        assertEquals(expectedOutput, actualOutput);
    }


}
