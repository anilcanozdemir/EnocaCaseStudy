package com.enoca.enocacasestudy.Service.Contract;




import com.enoca.enocacasestudy.Core.Result.DataResult;
import com.enoca.enocacasestudy.Core.Result.Result;

import java.util.List;

public interface CRUDService<EntityDTO, EntitySaveRequestDto> {

    Result add(EntitySaveRequestDto entitySaveRequestDto);

    DataResult<EntityDTO> deleteById(Long id);

    DataResult<List<EntityDTO>> getAll();

    DataResult<EntityDTO> getById(Long id);

    Result updateById(EntityDTO entityUpdateRequestDto);
}
