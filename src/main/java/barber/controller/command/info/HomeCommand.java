package barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.HOME_PAGE;

public class HomeCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(HOME_PAGE);
    }
}
