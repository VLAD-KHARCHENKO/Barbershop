package barber.controller.command.info;

import com.barber.controller.command.Command;
import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

import static com.barber.controller.PageUrlConstants.SERVICE_PAGE;


public class ServiceCommand implements Command {
    @Override
    public Page perform(HttpServletRequest request) {
        return new Page(SERVICE_PAGE);
    }
}
