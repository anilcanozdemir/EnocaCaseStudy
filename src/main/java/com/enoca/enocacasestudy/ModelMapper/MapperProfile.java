package com.enoca.enocacasestudy.ModelMapper;

public interface MapperProfile<EntityDto, EntitySaveRequestDto, Entity> {
    EntityDto entityToDTO(Entity entity);

    Entity saveRequestDtoToEntity(EntitySaveRequestDto entitySaveRequestDto);

    Entity DTOtoEntity(EntityDto updateRequestDto);

}
