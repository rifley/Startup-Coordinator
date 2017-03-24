import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");

      model.put("teams", request.session().attribute("teamSession"));
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/details", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/event-details.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("teams", request.session().attribute("teamSession"));
      model.put("template", "templates/teams.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/team-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team newTeam = new Team(request.queryParams("team"));
      model.put("team", newTeam);
      request.session().attribute("teamSession", newTeam.all());
      model.put("template", "templates/team-added.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:team_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team newTeam = Team.find(Integer.parseInt(request.params(":team_id")));
      model.put("team", newTeam);
      model.put("members", newTeam.getMembers());
      // request.session().attribute("teamSession");
      model.put("template", "templates/team.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:team_id/members/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team newTeam = Team.find(Integer.parseInt(request.params(":team_id")));
      model.put("team", newTeam);
      model.put("template", "templates/new-member-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/teams/:team_id/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team currentTeam = Team.find(Integer.parseInt(request.params(":team_id")));
      Member newMember = new Member(request.queryParams("member"));
      model.put("team", currentTeam);
      currentTeam.addMember(newMember);
      model.put("member", newMember);
      model.put("template", "templates/member-added.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/teams/:team_id/members", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Team currentTeam = Team.find(Integer.parseInt(request.params(":team_id")));
      model.put("team", currentTeam);
      model.put("teamMembers", currentTeam.getMembers());
      model.put("template", "templates/team-members.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());
  }
}
