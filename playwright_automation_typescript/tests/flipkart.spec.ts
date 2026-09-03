import {test, expect} from '@playwright/test';
test('Flipkart page opens successfully', async ({page})=>{
    await page.goto('https://www.flipkart.com');
    await expect(page).toHaveTitle(/Online Shopping Site for Mobiles/);
});