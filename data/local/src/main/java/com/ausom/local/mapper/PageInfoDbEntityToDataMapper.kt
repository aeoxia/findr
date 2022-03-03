package com.ausom.local.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PageInfoEntity
import com.ausom.local.model.PageInfoDbEntity
import javax.inject.Inject

class PageInfoDbEntityToDataMapper @Inject constructor() :
    OneWayMapper<PageInfoDbEntity, PageInfoEntity> {
    override fun map(before: PageInfoDbEntity): PageInfoEntity {
        return with(before) {
            PageInfoEntity(
                pageName = pageName,
                nextPageNumber = nextPageNumber,
                searchKeyword = searchKeyword
            )
        }
    }
}