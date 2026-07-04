package com.sample.sample_project_employee.mapper;

import com.sample.sample_project_employee.dto.EmployeeDto;
import com.sample.sample_project_employee.entity.Employee;
import com.sample.sample_project_employee.model.EmployeeModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto toEmployeeDto(EmployeeModel employeeModel);

    EmployeeModel toEmployeeModel(EmployeeDto employeeDto);

    @Mapping(target = "id", ignore = true)
    Employee toEntity(EmployeeModel employeeModel);

    EmployeeModel toEmployeeModel(Employee employee);

    // MapStruct automatically handles collection mapping based on single element mapping
    List<EmployeeDto> toEmployeeDtoList(List<EmployeeModel> employeeModels);

    List<EmployeeModel> toEmployeeModelList(List<Employee> employees);
}
