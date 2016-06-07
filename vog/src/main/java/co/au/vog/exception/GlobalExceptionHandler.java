package co.au.vog.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Class này có nhiệm vụ bắt tất cả các exception ném ra và hiển thị file error(trong trường hợp Exception nói chung)
 * Các exception khác có thể được bắt(ném ra) bởi các Controller class
 * @author Active User Co.,LTD 
 *
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(GenericException.class)
	public ModelAndView handleCustomException(GenericException ex) {

		ModelAndView model = new ModelAndView("publics/error");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("publics/error");
		model.addObject("errMsg", "this is Exception.class");

		return model;

	}
	
}
