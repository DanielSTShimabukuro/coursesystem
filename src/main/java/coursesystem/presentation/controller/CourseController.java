package coursesystem.presentation.controller;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import coursesystem.application.input.course.CreateCourseInputDTO;
import coursesystem.application.output.course.CourseOutputDTO;
import coursesystem.application.usecase.course.CreateCourseUseCase;
import coursesystem.application.usecase.course.FindByIdCourseUseCase;
import coursesystem.presentation.mapper.CoursePresentationMapper;
import coursesystem.presentation.request.course.CreateCourseRequestDTO;
import coursesystem.presentation.response.course.CourseResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@RequestMapping("/users/courses")
@RestController 
public class CourseController {
  private final CoursePresentationMapper mapper;
  private final CreateCourseUseCase createCourseUseCase;
  private final FindByIdCourseUseCase findByIdCourseUseCase;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping 
  public CourseResponseDTO createCourse(@RequestBody @Valid CreateCourseRequestDTO request) {
    CreateCourseInputDTO input = this.mapper.toInput(request);
    CourseOutputDTO output = this.createCourseUseCase.execute(input);

    return this.mapper.toResponse(output);
  }

  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/{id}")
  public CourseResponseDTO findUserById(@PathVariable UUID id) {
    CourseOutputDTO output = this.findByIdCourseUseCase.execute(id);

    return this.mapper.toResponse(output);
  }
}
