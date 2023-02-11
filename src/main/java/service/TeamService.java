package service;

import dao.TeamDAO;
import model.Teacher;
import model.Team;
import model.User;
import model.UserType;

public class TeamService {

    private TeamDAO teamDAO = new TeamDAO();
    public Team createTeam(Team team, Teacher teacher) {
        team.setTeacher(teacher);
        Team persistedTeam = this.teamDAO.createTeam(team);
        return persistedTeam;
    }
}
