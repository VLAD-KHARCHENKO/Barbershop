package barber.controller.command;

import com.barber.controller.data.Page;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    Page perform(HttpServletRequest request);
}
