package com.ausom.local.mapper

import com.ausom.core.abstraction.OneWayMapper
import com.ausom.data.model.PageInfoEntity
import com.ausom.local.model.PageInfoDbEntity
import javax.inject.Inject

class PageInfoEntityToLocalDataMapper @Inject constructor() :
    OneWayMapper<PageInfoEntity, PageInfoDbEntity> {
    override fun map(before: PageInfoEntity): PageInfoDbEntity {
        return with(before) {
            PageInfoDbEntity(
                pageName = pageName,
                nextPageNumber = nextPageNumber,
                searchKeyword = searchKeyword
            )
        }
    }
}