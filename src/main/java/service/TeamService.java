package service;

import dao.TeamDAO;
import helper.FormatHelper;
import model.Teacher;
import model.Team;
import model.User;
import model.UserType;

public class TeamService {

    private final TeamDAO teamDAO = new TeamDAO();
    public Team createTeam(Team team, Teacher teacher) {
        team.setTeacher(teacher);
        Team persistedTeam = this.teamDAO.createTeam(team);
        return persistedTeam;
    }


    private String generateCode(String nomeTurma){
        String code = FormatHelper.generateCodigoTurma(nomeTurma);
        return teamDAO.getTeamByCode(code) == null ? code : generateCode(nomeTurma);
    }
}
