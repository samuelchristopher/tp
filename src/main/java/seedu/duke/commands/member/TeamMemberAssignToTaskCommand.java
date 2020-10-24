package seedu.duke.commands.member;

import seedu.duke.DukeExceptions;
import seedu.duke.commands.Command;
import seedu.duke.member.TeamMember;
import seedu.duke.project.Project;
import seedu.duke.task.Task;
import seedu.duke.ui.Ui;

import java.util.ArrayList;
import java.util.HashMap;

import static seedu.duke.Parser.getHashValue;

public class TeamMemberAssignToTaskCommand extends Command {

    private int taskIndex;
    private int projectIndex;
    private int memberIndex;
    HashMap<String, String> params;

    public TeamMemberAssignToTaskCommand(HashMap<String, String> params, int projectIndex)
            throws DukeExceptions {
        this.params = params;
        this.projectIndex = projectIndex;
        this.parse();
    }

    public void parse() throws DukeExceptions {
        try {
            taskIndex = Integer.parseInt(getHashValue(params, "t")) - 1;
            memberIndex = Integer.parseInt(getHashValue(params, "m")) - 1;
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            throw new DukeExceptions("invalidTaskID");
        }
    }

    public String executeCommand(ArrayList<Project> projects, ArrayList<TeamMember> teamMembers) throws DukeExceptions {
        if (projects.size() == 0) {
            throw new DukeExceptions("emptyProjectList");
        }
        Task selectedTask = projects.get(projectIndex).getTask(taskIndex);
        TeamMember member = teamMembers.get(memberIndex);
        selectedTask.setMember(member);
        return Ui.printMemberAssignedToTaskMessage(member.getName(), selectedTask.getTaskDescription());
    }

    public Boolean isExit() {
        return false;
    }
}
