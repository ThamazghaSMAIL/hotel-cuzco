import { expect }     from 'chai'
import { HelloWorld } from '../src/helloWorld'

describe('Starter', () => {
    it('do something', () => {
        expect(new HelloWorld().speak).to.be.equal('hello world')
    })
})
